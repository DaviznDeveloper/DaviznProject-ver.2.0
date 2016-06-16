package kr.or.davizn.boardController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.boardDTO.QandAReplyDTO;
import kr.or.davizn.boardService.QandAReply;

@Controller
@RequestMapping("/QnA/")
public class QandAReplyController {
	@Autowired
	private QandAReply QandAReplyService;

	// 댓글 처리
	@RequestMapping(value = "replyWrite.dvn", method = RequestMethod.POST)
	public String noticeReg(QandAReplyDTO dto, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		System.out.println("댓글 입력 컨트롤러");
		String url = "QnA.qna-list";
		System.out.println(dto);
		try {
			url = QandAReplyService.replyReg(dto, request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return url;

	}
	
	@RequestMapping(value="deleteReply.dvn")
	public String deleteReply(int boardseq, int replynum){
		System.out.println("딜리트 댓글");
		String url = "QnA.qna-list";
		try {
			url = QandAReplyService.delReply(replynum, url)+"?boardseq="+boardseq;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
