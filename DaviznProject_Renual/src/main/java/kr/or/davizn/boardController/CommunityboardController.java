package kr.or.davizn.boardController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.davizn.boardDTO.CommunityBoardDTO;
import kr.or.davizn.boardService.CommunityBoard;

@Controller
public class CommunityboardController {

	@Autowired
	private CommunityBoard communityboardservice;
	
	//글 목록보기
	@RequestMapping("communityList.dvn")
	@Transactional
	public String notices(String pg , String f , String q , Model model) throws ClassNotFoundException , SQLException {
		List<CommunityBoardDTO> list = communityboardservice.notices(pg, f , q);
		
		model.addAttribute("list" , list);
		System.out.println(list);
		return "community.community-list";
			
	}
	
	//글상세보기
	@RequestMapping("/community/communitydetail.dvn")
	@Transactional
	public String noticeDetail(String seq, Model model) throws ClassNotFoundException, SQLException{
		CommunityBoardDTO notice = communityboardservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		return "community.community-detail";
		
	}
	
	//글 입력 화면처리
	@RequestMapping(value = "/community/communitywrite.dvn", method = RequestMethod.GET)
	public String noticeReg() {
		return "community.community-write";
	}
	
	//글 등록 처리
	@RequestMapping(value = "/community/communitywrite.dvn",method= RequestMethod.POST)
	public String noticeReg(CommunityBoardDTO dto) 
			throws IOException, ClassNotFoundException, SQLException {
		System.out.println("등록처리");
		String url = "community.community-list";
		try {
			url = communityboardservice.noticeReg(dto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return url;
	}
	
}





