package kr.or.davizn.boardService;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.boardDTO.QandAReplyDTO;
import kr.or.davizn.boardInterface.QandAreplyDAO;

@Service
public class QandAReply {
		@Autowired
		SqlSession SqlSession;
		// 댓글 등록		
		public String replyReg(QandAReplyDTO n, HttpServletRequest request) throws Exception {
			QandAreplyDAO QandAreplyDao = SqlSession.getMapper(QandAreplyDAO.class);
			System.out.println("댓글 서비스 등장");
			System.out.println(n);
			System.out.println(n.getBoardseq());
			QandAreplyDao.insertReply(n);
			System.out.println("Insert 완료");
			return "redirect:/QnA/Qnadetail.dvn?boardseq="+n.getBoardseq();
		}
		
		public String delReply(int replynum, String userid) throws ClassNotFoundException, SQLException{
			System.out.println("시퀀스 :"+replynum);
			QandAreplyDAO QandAreplyDao = SqlSession.getMapper(QandAreplyDAO.class);
			QandAreplyDao.deleteReply(replynum);

			return "redirect:/QnA/Qnadetail.dvn";
		}
}
