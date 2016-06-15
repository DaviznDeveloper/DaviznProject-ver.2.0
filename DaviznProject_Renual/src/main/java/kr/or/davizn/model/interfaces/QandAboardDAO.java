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
		public QandAboardDTO getNotice(int boardseq) throws ClassNotFoundException, SQLException;
		//조회수 증가
		public int boardCount(int boardseq) throws ClassNotFoundException, SQLException;
		//게시물 입력
		public int insert(QandAboardDTO n) throws ClassNotFoundException, SQLException;
		//트랜잭션 TEST
		public boolean insertOfMemberPoint(String userid) throws ClassNotFoundException, SQLException;
		//댓글 조회
		public List<QandAReplyDTO> replylist(int boardseq) throws ClassNotFoundException, SQLException;
		//덧글 리스트
		public List<QandAReplyDTO> replyList(int boardseq) throws ClassNotFoundException, SQLException;
		
		
	
		

		
		
}
