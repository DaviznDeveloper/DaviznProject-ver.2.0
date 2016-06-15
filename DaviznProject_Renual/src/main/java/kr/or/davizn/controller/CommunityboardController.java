package kr.or.davizn.controller; 

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

import kr.or.davizn.model.dto.CommunityBoardDTO;
import kr.or.davizn.service.CommunityBoard;

@Controller
public class CommunityboardController {

	@Autowired
	private CommunityBoard communityboardservice;
	
	//글 목록보기
	@RequestMapping("communityList.dvn")
	public String notices(String pg, Model model) throws ClassNotFoundException , SQLException {
		
		List<CommunityBoardDTO> list = communityboardservice.notices(pg, model);
		model.addAttribute("list", list); 
		return "community.community-list";
			
	}
	//글상세보기
	@RequestMapping("/community/communitydetail.dvn")
	public String noticeDetail(String seq, Model model) throws ClassNotFoundException, SQLException{
		
		CommunityBoardDTO notice = communityboardservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		return "community.community-detail";
		
	}
	
	//글 입력 화면처리
	@RequestMapping(value = "/community/communitywrite.dvn", method = RequestMethod.GET)
	public String noticeReg(Principal principal, Model model) {
		System.out.println("등록 경로 컨드롤러1");
		String userid = principal.getName();
		model.addAttribute("userid" , userid);
		return "community.community-write";
	}
	
	//글 등록 처리
	@RequestMapping(value = "/community/communitywrite.dvn",method= RequestMethod.POST)
	public String noticeReg(CommunityBoardDTO dto) 
			throws IOException, ClassNotFoundException, SQLException {
		
		System.out.println("등록컨트롤2");
		System.out.println(dto);
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
	public String noticeEdit(String boardseq, Model model)
	throws ClassNotFoundException, SQLException {
		CommunityBoardDTO notice = communityboardservice.noticeEdit1(boardseq);
		model.addAttribute("notice", notice);
		return "community.community-modify";
	}
	
	//게시판 실제 수정처리
	@RequestMapping(value = "/community/communityedit.dvn" , method = RequestMethod.POST)
	public String noticeEdit(CommunityBoardDTO n , HttpServletRequest request) throws 
	ClassNotFoundException, SQLException , IOException {
		System.out.println("edit수정처리");
		System.out.println("seq : " + n.getBoardseq());
		String url = communityboardservice.noticeEdit2(n, request);
		System.out.println("url : " + url);
		return url;
		
	}
	
	//글 삭제하기
	@RequestMapping("/community/communitydel.dvn")
	public String noticeDel(String boardseq) throws ClassNotFoundException, 
	SQLException {
		String url = communityboardservice.noticeDel(boardseq);
		System.out.println(url);
		return url;
		
	}
}





