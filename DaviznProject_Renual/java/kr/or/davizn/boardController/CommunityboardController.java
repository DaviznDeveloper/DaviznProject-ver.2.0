package kr.or.davizn.boardController; 

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.davizn.boardDTO.CommunityBoardDTO;
import kr.or.davizn.boardDTO.CommunityReplyDTO;
import kr.or.davizn.boardService.CommunityBoard;




@Controller
public class CommunityboardController {

	@Autowired
	private CommunityBoard communityboardservice;
	
	//글 목록보기
	@RequestMapping("communityList.dvn")
	public String notices(String pg, Model model, @RequestParam(defaultValue="5", required=false)String rowSize) throws ClassNotFoundException , SQLException {
		
		List<CommunityBoardDTO> list = communityboardservice.notices(pg, model, Integer.parseInt(rowSize));
		System.out.println("list : " + list);
		model.addAttribute("list", list);
		model.addAttribute("rSize",rowSize);
		model.addAttribute("list" , list);
		return "community.community-list";
			
	}
	//글상세보기
	@RequestMapping("/community/communitydetail.dvn")
	public String noticeDetail(int boardseq, Model model) throws ClassNotFoundException, SQLException{
		
		CommunityBoardDTO notice = communityboardservice.noticeDetail(boardseq);
		List<CommunityReplyDTO> replylist = communityboardservice.replyDetail(boardseq);
		
		model.addAttribute("replylist" , replylist);
		model.addAttribute("notice", notice);
		return "community.community-detail";
		
	}
	
	//글 입력 화면처리
	@RequestMapping(value = "/community/communitywrite.dvn", method = RequestMethod.GET)
	public String noticeReg(Principal principal, Model model) {
		
		String userid = principal.getName();
		model.addAttribute("userid" , userid);
		return "community.community-write";
	}
	
	//글 등록 처리
	@RequestMapping(value = "/community/communitywrite.dvn",method= RequestMethod.POST)
	public String noticeReg(CommunityBoardDTO dto) 
			throws IOException, ClassNotFoundException, SQLException {
		
		String url = "community.community-list";
		try {
			url = communityboardservice.noticeReg(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return url;
	}
	
	//글 수정하기 (두가지 처리 : 화면(select) , 처리(update))
	//글수정하기 (수정하기 화면 , 수정처리)
	//주소같고 처리(GET , POST) 처리
	@RequestMapping(value = "/community/communityedit.dvn" , method = RequestMethod.GET)
	public String noticeEdit(int boardseq, Model model)
	throws ClassNotFoundException, SQLException {
		
		CommunityBoardDTO notice = communityboardservice.noticeEdit1(boardseq);
		model.addAttribute("notice", notice);
		return "community.community-modify";
	}
	
	//게시판 실제 수정처리
	@RequestMapping(value = "/community/communityedit.dvn" , method = RequestMethod.POST)
	public String noticeEdit(CommunityBoardDTO n , HttpServletRequest request) throws 
	ClassNotFoundException, SQLException , IOException {
		
		String url = communityboardservice.noticeEdit2(n, request);
	
		return url;
		
	}
	
	//글 삭제하기
	@RequestMapping("/community/communitydel.dvn")
	public String noticeDel(String boardseq) throws ClassNotFoundException, 
	SQLException {
		
		String url = communityboardservice.noticeDel(boardseq);
	
		return url;
			
	}
	
	//게시글 검색
	 @RequestMapping(value="/community/search.dvn")
	public ModelAndView boardList(String keyfield, String keyword) throws ClassNotFoundException, 
	SQLException, IOException {
		
		
		List<CommunityBoardDTO> list = null;
		
		list = communityboardservice.boardList(keyfield, keyword);

		return new ModelAndView("community.community-list" , "list" , list);
		
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	//답 글 등록 화면 처리
	@RequestMapping(value = "cmreplyReg.dvn", method = RequestMethod.GET)
	public String noticeReplyReg(CommunityBoardDTO dto , Model model) {
		System.out.println("답글 컨트롤러");
		int boardref = dto.getBoardref();
		System.out.println("id"+dto.getUserid());
		model.addAttribute("blist",dto);
		//model.addAttribute("dto", dto);
		return "community.cmreply-write";
	}

	//답 글 등록 실제 처리
	@RequestMapping(value = "cmreplyReg.dvn", method = RequestMethod.POST)
	public String noticeReplyReg(CommunityBoardDTO dto, HttpServletRequest request , Principal principal)
			throws ClassNotFoundException, SQLException {
		System.out.println("컨트롤러111111111");
		System.out.println(dto.getBoardref());
		System.out.println("userid : " + dto.getUserid());
		System.out.println(dto.toString());
		System.out.println("lev" + dto.getBoardlev());
		dto.setUserid(principal.getName());
		String url = "";	
		try {
			url = communityboardservice.noticeReplyReg(dto);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return url;
		
		
	}

	
	
	
	
	
	
	
	
	
}





