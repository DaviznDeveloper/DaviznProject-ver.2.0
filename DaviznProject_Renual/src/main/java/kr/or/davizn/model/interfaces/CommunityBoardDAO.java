package kr.or.davizn.model.interfaces;

import java.sql.SQLException;
import java.util.List;

import kr.or.davizn.model.dto.CommunityBoardDTO;

//CRUD

public interface CommunityBoardDAO {
	
	//게시물 개수
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException;

	//글 목록 보기
	public List<CommunityBoardDTO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	//글 상세 보기
	public CommunityBoardDTO getNotice(String boardseq) throws ClassCastException, SQLException;
	
	//글 입력하기
	public int insert(CommunityBoardDTO n) throws ClassNotFoundException, SQLException;
	
	//글 수정하기
	public int update(CommunityBoardDTO communityboarddto) throws ClassNotFoundException, SQLException;
	
	//글 삭제하기
	public int delete(String boardseq) throws ClassCastException, SQLException;
	
	//조회수 증가
	//public int boardCount(int boardseq) throws ClassCastException, SQLException;
	
	//글 검색하기
	public int getSearch(String field, String query) throws ClassNotFoundException, SQLException;
	
	
	
	
	//답 글 쓰기
	
	//답 글 수정하기
	
	//답 글 삭제하기
	
	
	
	
}
