package kr.or.davizn.boardController;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.davizn.boardDTO.QandAReplyDTO;
import kr.or.davizn.boardDTO.QandAboardDTO;
import kr.or.davizn.boardService.QandAboard;

@Controller
public class QandAboardController {

	@Autowired
	private QandAboard QandAboardservice;

	// 글목록보기
	@RequestMapping("QnAList.dvn")
	public String notices(String pg, Model model, @RequestParam(defaultValue = "5", required = false) String rowSize)
			throws ClassNotFoundException, SQLException {
		List<QandAboardDTO> list = QandAboardservice.notices(pg, model, Integer.parseInt(rowSize));
		model.addAttribute("list", list);
		model.addAttribute("rSize", rowSize);

		return "QnA.qna-list";
	}

	// 글상세보기
	@Transactional
	@RequestMapping("/QnA/Qnadetail.dvn")
	public String noticeDetail(int boardseq, Model model) throws ClassNotFoundException, SQLException {
		QandAboardDTO notice = QandAboardservice.noticeDetail(boardseq);
		List<QandAReplyDTO> replylist = QandAboardservice.replyDetail(boardseq);
		model.addAttribute("replylist", replylist);
		model.addAttribute("notice", notice);
		return "QnA.qna-detail";

	}

	// 글등록 화면 처리
	@Transactional
	@RequestMapping(value = "/QnA/qnaWrite.dvn", method = RequestMethod.GET)
	public String noticeReg(Principal principal, Model model) {
		String userid = principal.getName();
		model.addAttribute("userid", userid);
		return "QnA.qna-write";
	}

	// 글등록 처리(실제 글등록 처리)
	@RequestMapping(value = "/QnA/qnaWrite.dvn", method = RequestMethod.POST)
	public String noticeReg(QandAboardDTO dto, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		String url = "QnA.qna-list";
		try {
			url = QandAboardservice.noticeReg(dto, request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return url;

	}

	// 글삭제하기
	@RequestMapping("/QnA/QnaDel.dvn")
	public String noticeDel(String boardseq) throws ClassNotFoundException, SQLException {
		String url = QandAboardservice.noticeDel(boardseq);
		return url;
	}

	// 글수정하기 (두가지 처리 : 화면(select) , 처리(update))
	// 글수정하기 (수정하기 화면 , 수정처리)
	// 주소같고 처리(GET , POST) 처리
	@Transactional
	@RequestMapping(value = "/QnA/QnAEdit.dvn", method = RequestMethod.GET)
	public String noticeEdit(int boardseq, Model model) throws ClassNotFoundException, SQLException {
		QandAboardDTO notice = QandAboardservice.noticeEdit1(boardseq);
		model.addAttribute("notice", notice);
		return "QnA.qna-modify";
	}

	// 게시판 실제 수정처리
	@RequestMapping(value = "/QnA/QnAEdit.dvn", method = RequestMethod.POST)
	public String noticeEdit(QandAboardDTO n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {
		String url = QandAboardservice.noticeEdit2(n, request);
		return url;
	}

	// 게시글 검색
	@RequestMapping(value = "/QnA/search.dvn")
	public ModelAndView boardList(String keyfield, String keyword)
			throws ClassNotFoundException, SQLException, IOException {
		List<QandAboardDTO> list = null;
		list = QandAboardservice.boardList(keyfield, keyword);
		return new ModelAndView("QnA.qna-list", "list", list);
	}

}
