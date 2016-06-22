package kr.or.davizn.boardInterface;

import java.sql.SQLException;

import kr.or.davizn.boardDTO.CommunityReplyDTO;


public interface CommunityreplyDAO {
	//답변 쓰기
	public int insertReply(CommunityReplyDTO n) throws ClassNotFoundException, SQLException;
		
	//해당 댓 글 삭제
	public int deleteReply(int replynum) throws ClassNotFoundException, SQLException;
	
	
}
