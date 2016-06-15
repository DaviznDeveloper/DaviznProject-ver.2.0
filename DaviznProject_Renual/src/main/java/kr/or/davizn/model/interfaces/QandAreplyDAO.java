package kr.or.davizn.model.interfaces;

import java.sql.SQLException;

import kr.or.davizn.model.dto.QandAReplyDTO;

public interface QandAreplyDAO {
	//답변
	public int insertReply(QandAReplyDTO n) throws ClassNotFoundException, SQLException;
	//댓글쓰기
	public int noticeReqly(QandAReplyDTO n) throws ClassNotFoundException, SQLException;	
	//해당덧글 삭제
	public int deleteReply(int replynum) throws ClassNotFoundException, SQLException;
	//덧글삭제시 참조키
	public int replySeq(int seq_pk) throws ClassNotFoundException, SQLException;
}
