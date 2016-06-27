package kr.or.davizn.boardInterface;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.davizn.boardDTO.QandAReplyDTO;
import kr.or.davizn.boardDTO.QandAboardDTO;

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
	//게시글 검색
	public List<QandAboardDTO> boardSearch(Map<String, String> map) throws ClassNotFoundException, SQLException;
	//권한 체크
	public String checkPwd(int boardseq) throws ClassNotFoundException, SQLException;
		
}
