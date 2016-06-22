package kr.or.davizn.boardService;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.boardDTO.CommunityBoardDTO;
import kr.or.davizn.boardInterface.CommunityBoardDAO;

@Service
public class CommunityBoard {

	@Autowired
	private SqlSession SqlSession;

	// 글 목록 보기
	public List<CommunityBoardDTO> notices(String pg, String f, String q) throws ClassNotFoundException, SQLException {

		int page = 1;
		String field = "boardsubject";
		String query = "%%";

		if (pg != null && pg.equals("")) {
			page = Integer.parseInt(pg);
		}
		if (f != null && f.equals("")) {
			field = f;
		}
		if (q != null && q.equals("")) {
			query = q;
		}
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		// System.out.println(communityBoardDAO.toString());
		// System.out.println("서비스2");
		System.out.println("comm : " + communityBoardDAO.hashCode());
		List<CommunityBoardDTO> list = communityBoardDAO.getNotices(page, field, query);

		return list;

	}

	// 글 상세보기
	public CommunityBoardDTO noticeDetail(String boardseq) throws ClassNotFoundException, SQLException {
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		CommunityBoardDTO notice = communityBoardDAO.getNotice(boardseq);
		// communityBoardDAO.boardCount(Integer.parseInt(boardseq));
		return notice;
	}

	// 글 등록하기
	public String noticeReg(CommunityBoardDTO n) throws Exception {
		CommunityBoardDAO communityBoardDAO = SqlSession.getMapper(CommunityBoardDAO.class);
		communityBoardDAO.insert(n);
		return "redirect:community.dvn";
	}

}
