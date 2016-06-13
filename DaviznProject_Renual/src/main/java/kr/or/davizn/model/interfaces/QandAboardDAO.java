package kr.or.davizn.model.interfaces;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.or.davizn.model.dto.QandAReplyDTO;
import kr.or.davizn.model.dto.QandAboardDTO;

public interface QandAboardDAO {
		//게시물 개수
		public int getCount() throws ClassNotFoundException, SQLException;
		//전체 게시물
		public List<QandAboardDTO> getNotices(HashMap maps) throws ClassNotFoundException, SQLException;
		//게시물 삭제
		public int delete(String boardseq) throws ClassNotFoundException, SQLException;
		//게시물 수정
		public int update(QandAboardDTO notice) throws ClassNotFoundException, SQLException;
		//게시물 상세
		public QandAboardDTO getNotice(String boardseq) throws ClassNotFoundException, SQLException;
		//조회수 증가
		public int boardCount(int boardseq) throws ClassNotFoundException, SQLException;
		//게시물 입력
		public int insert(QandAboardDTO n) throws ClassNotFoundException, SQLException;
		//트랜잭션 TEST
		public boolean insertOfMemberPoint(String userid) throws ClassNotFoundException, SQLException;
		
		//답변
		public int replyBoard(QandAboardDTO n) throws ClassNotFoundException, SQLException;
		//최상위 부모글 번호 생성
		//public int getRefMax() throws ClassNotFoundException, SQLException;
		
		public int refer_depth_step_sql(QandAboardDTO n) throws ClassNotFoundException, SQLException;
		//답글의 순번 생성
		/*public int getStepMax(Notice n) throws ClassNotFoundException, SQLException;
		//최상위 부모값을 가진 것 중 현재 답글을 달 게시물의순번보다 +1하여 밀리게
	*/	public void updateCommunityStep(QandAboardDTO n) throws ClassNotFoundException, SQLException;

		public void updateCommunityDepth(QandAboardDTO n) throws ClassNotFoundException, SQLException;		
		//댓글쓰기
		public int noticeReqly(QandAReplyDTO n) throws ClassNotFoundException, SQLException;
		//덧글 리스트
		public List<QandAReplyDTO> replyList(int boardseq) throws ClassNotFoundException, SQLException;
		//모든댓글 삭제
		public int deleteAllReply(String boardseq) throws ClassNotFoundException, SQLException;
		//해당덧글 삭제
		public int deleteReply(int seq_pk) throws ClassNotFoundException, SQLException;
		//덧글삭제시 참조키
		public int replySeq(int seq_pk) throws ClassNotFoundException, SQLException;
		//최상위 덧글
		public int getReplyMax() throws ClassNotFoundException, SQLException;
		//덧글 스텝 +1
		public void updateReplyStep(QandAReplyDTO n) throws ClassNotFoundException, SQLException;
		//덧글 뎁스 +1
		public void updateReplyDepth(QandAReplyDTO n) throws ClassNotFoundException, SQLException;
		
		public int replyReInsert(QandAReplyDTO n) throws ClassNotFoundException, SQLException;
}
