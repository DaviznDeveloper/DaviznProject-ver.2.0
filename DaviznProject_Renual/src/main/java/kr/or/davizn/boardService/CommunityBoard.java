package kr.or.davizn.boardService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.or.davizn.boardDTO.CommunityBoardDTO;
import kr.or.davizn.boardDTO.CommunityReplyDTO;
import kr.or.davizn.boardInterface.CommunityBoardDAO;



@Service
public class CommunityBoard {

	@Autowired
	private SqlSession SqlSession;
	
	//글 목록 보기
	public List<CommunityBoardDTO> notices(String pg, Model model, int rowSize) throws ClassNotFoundException , SQLException {
		
		int page = 1;
		
		if(pg != null )
		{
			page = Integer.parseInt(pg);
		}
		
		int start = (page * rowSize) - (rowSize - 1);
		int end = page * rowSize;
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		int total = communityBoardDAO.getCount();
		
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);
		
		//목록...
		int allPage = (int) Math.ceil(total / (double) rowSize);	//페이지수
		System.out.println("페이지수  : " + allPage);
		
		int block = 5;
		int fromPage = ((page - 1) / block * block) + 1;	//보여줄 페이지의 시작
		int toPage = ((page - 1) / block *block) + block;	//보여줄 페이지의 끝
		if (toPage > allPage) // 예 20 > 17
		{
			toPage = allPage;
		}
		
		//start 와 end 값을 map에 담음
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		
		List<CommunityBoardDTO> list = communityBoardDAO.getNotices(map);
		
		model.addAttribute("list",list);
		model.addAttribute("rowSize",rowSize);
		model.addAttribute("pg",page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("block",block);
		model.addAttribute("fromPage",fromPage);
		model.addAttribute("toPage",toPage);	
		System.out.println(communityBoardDAO);
		return list;
		
	}
	
	//글 상세보기
	public CommunityBoardDTO noticeDetail(int boardseq) throws ClassNotFoundException, SQLException{
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		CommunityBoardDTO notice = communityBoardDAO.getNotice(boardseq);
		
		communityBoardDAO.boardCount(boardseq);
		System.out.println(communityBoardDAO);
		return notice;
		
	}
	//댓 글보기
	public List<CommunityReplyDTO> replyDetail(int boardseq) throws ClassNotFoundException, SQLException {

		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		List<CommunityReplyDTO> reqlylist = communityBoardDAO.replylist(boardseq);
		System.out.println(communityBoardDAO);
		return reqlylist;

	}
	
	//글  등록하기
	public String noticeReg(CommunityBoardDTO n) throws Exception {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.insert(n);
		return "redirect:/communityList.dvn";
	}
	
	//글 수정하기
	public CommunityBoardDTO noticeEdit1(int boardseq) throws ClassNotFoundException, SQLException {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		CommunityBoardDTO notice = communityBoardDAO.getNotice(boardseq);
		return notice;
		
	}
	
	//게시글 수정 확인!
	public String noticeEdit2(CommunityBoardDTO n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {
		
		//Mybatis 적용
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.update(n);
		
		return "redirect:/communityList.dvn";
		
	}
		
	
	//글 삭제하기
	public String noticeDel(String boardseq) throws ClassNotFoundException, SQLException{
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.delete(boardseq);
		return "redirect:/communityList.dvn";
	}
	
	
	//답 글  등록하기
	public String noticeReplyReg(CommunityBoardDTO n) throws ClassNotFoundException, SQLException {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		System.out.println("boardlev : " + n.getBoardlev()); //들여쓰기
		
		System.out.println("22222222222222222222222");
		communityBoardDAO.updateCommunityDepth(n);
		
		System.out.println("service");
		System.out.println("n1" + n);
		System.out.println("userid2 : " + n.getUserid());
		System.out.println("ref : "+n.getBoardref());
		System.out.println("userid1 : " + n.getUserid());
		communityBoardDAO.replyBoard(n);
		System.out.println("n2" + n);
		
		
		return "redirect:/communityList.dvn";
	}
	
	//글 검색하기
	public List<CommunityBoardDTO> boardList(String keyfield , String keyword) throws ClassNotFoundException , SQLException {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		List<CommunityBoardDTO> searchlist = communityBoardDAO.boardSearch(map);
		System.out.println(map.toString());
		System.out.println("정상적으로 값이 들어옴");
        System.out.println(keyfield + "//" + keyword);
        System.out.println(searchlist.size());
	    
        return searchlist;
		
	}
}













