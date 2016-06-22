package kr.or.davizn.boardService;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.boardDTO.CommunityReplyDTO;
import kr.or.davizn.boardInterface.CommunityreplyDAO;



@Service
public class CommunityReply {

	@Autowired
	SqlSession SqlSession;
	//댓 글 등록
	public String replyReg(CommunityReplyDTO n , HttpServletRequest request) throws Exception {     
		CommunityreplyDAO communityreplyDAO = SqlSession.getMapper(CommunityreplyDAO.class);
		System.out.println("댓글 서비스 ");
		System.out.println(n);
		System.out.println(n.getBoardseq());
		communityreplyDAO.insertReply(n);
		System.out.println("insert success");
		return "redirect:/community/communitydetail.dvn?boardseq="+n.getBoardseq();
	}
	
	//댓 글 삭제
	public String delReply(int replynum , String userid) throws ClassNotFoundException , SQLException {
		
		CommunityreplyDAO communityreplyDAO = SqlSession.getMapper(CommunityreplyDAO.class);
		communityreplyDAO.deleteReply(replynum);
		
		return "redirect:/community/communitydetail.dvn";
	}
}
