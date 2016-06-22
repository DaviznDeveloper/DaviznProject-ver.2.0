package kr.or.davizn.boardInterface;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.davizn.boardDTO.CommunityBoardDTO;
import kr.or.davizn.boardDTO.CommunityReplyDTO;


//CRUD

public interface CommunityBoardDAO {
	
	//게시물 개수
	public int getCount() throws ClassNotFoundException, SQLException;

	//글 목록 보기
	public List<CommunityBoardDTO> getNotices(HashMap maps) throws ClassNotFoundException, SQLException;
	
	//글 상세 보기
	public CommunityBoardDTO getNotice(int boardseq) throws ClassCastException, SQLException;
	
	//글 입력하기
	public int insert(CommunityBoardDTO n) throws ClassNotFoundException, SQLException;
	
	//글 수정하기
	public int update(CommunityBoardDTO notice) throws ClassNotFoundException, SQLException;
	
	//글 삭제하기
	public int delete(String boardseq) throws ClassCastException, SQLException;
	
	//조회수 증가
	public int boardCount(int boardseq) throws ClassCastException, SQLException;
	
	//게시글 검색
	public List<CommunityBoardDTO> boardSearch(Map<String, String> map) throws ClassNotFoundException, SQLException;

			
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	//댓 글 보기
	public List<CommunityReplyDTO> replylist(int boardseq) throws ClassNotFoundException, SQLException;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//답 글 쓰기
	public int replyBoard (CommunityBoardDTO n) throws ClassNotFoundException, SQLException;
		
	//덧 글 뎁스 +1
	public void updateCommunityDepth(CommunityBoardDTO n) throws ClassNotFoundException, SQLException;
	
	
	
	
}
