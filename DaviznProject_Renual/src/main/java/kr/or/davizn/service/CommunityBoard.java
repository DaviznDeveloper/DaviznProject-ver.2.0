package kr.or.davizn.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.davizn.model.dto.CommunityBoardDTO;
import kr.or.davizn.model.dto.QandAboardDTO;
import kr.or.davizn.model.interfaces.CommunityBoardDAO;


@Service
public class CommunityBoard {

	@Autowired
	private SqlSession SqlSession;
	
	//글 목록 보기
	public List<CommunityBoardDTO> notices(String pg, Model model) throws ClassNotFoundException , SQLException {
		
		int page = 1;
		String strpg = pg;
		if(strpg != null )
		{
			page = Integer.parseInt(strpg);
		}
		
		int rowSize = 5;
		int start = (page*rowSize) - (rowSize - 1);
		int end = page*rowSize;
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		int total = communityBoardDAO.getCount();
		
		System.out.println("start_page : " +  start);
		System.out.println("end_page :  " +  end );
		System.out.println("총 게시물 건수 : " + total);
		
		//목록...
		int allPage = (int)Math.ceil(total / (double) rowSize);	//페이지수
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
		model.addAttribute("pg",page);
		model.addAttribute("allPage",allPage);
		model.addAttribute("block",block);
		model.addAttribute("fromPage",fromPage);
		model.addAttribute("toPage",toPage);	
		System.out.println("서비스 단 list"+list);
		
		return list;
		
	}
	
	//글 상세보기
	public CommunityBoardDTO noticeDetail(String boardseq) throws ClassNotFoundException, SQLException{
		System.out.println("상세 서비스");
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		CommunityBoardDTO notice = communityBoardDAO.getNotice(boardseq);
		communityBoardDAO.boardCount(Integer.parseInt(boardseq));
		return notice;
		
	}
	
	//글  등록하기
	public String noticeReg(CommunityBoardDTO n) throws Exception {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		System.out.println("등록 서비스");
		communityBoardDAO.insert(n);
		return "redirect:/communityList.dvn";
	}
	
	//글 수정하기
	public CommunityBoardDTO noticeEdit1(String boardseq) throws ClassNotFoundException, SQLException {
		
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		CommunityBoardDTO notice = communityBoardDAO.getNotice(boardseq);
		return notice;
		
	}
	
	//게시글 수정 확인!
	public String noticeEdit2(CommunityBoardDTO n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("adsjlfksdahasdlkfhgasdklfj"+n);		
		//Mybatis 적용
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.update(n);
		
		return "redirect:/communityList.dvn";
		
	}
		
	
	//글 삭제하기
	public String noticeDel(String boardseq) throws ClassNotFoundException, SQLException{
		System.out.println("삭제 서비스");
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.delete(boardseq);
		return "redirect:/communityList.dvn";
	}
	
}













