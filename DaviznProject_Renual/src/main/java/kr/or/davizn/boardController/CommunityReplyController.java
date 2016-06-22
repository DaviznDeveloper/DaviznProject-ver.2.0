package kr.or.davizn.boardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.boardDTO.CommunityReplyDTO;
import kr.or.davizn.boardService.CommunityReply;


@Controller
@RequestMapping("/community/")
public class CommunityReplyController {
	@Autowired
	private CommunityReply communityReplyService;

	// 댓글 처리
	@RequestMapping(value = "replyWrite.dvn", method = RequestMethod.POST)
	public String noticeReg(CommunityReplyDTO dto, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		System.out.println("댓글 입력 컨트롤러");
		String url = "community.community-list";
		System.out.println(dto);
		try {
			url = communityReplyService.replyReg(dto, request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return url;

	}
	@RequestMapping(value="deleteReply.dvn")
	public String deleteReply(int boardseq , int replynum) {
		String url = "community.community-list";
		try{
		url = communityReplyService.delReply(replynum, url)+"?boardseq="+boardseq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	

}
