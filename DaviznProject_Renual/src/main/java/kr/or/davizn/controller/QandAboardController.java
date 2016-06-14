package kr.or.davizn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.davizn.model.dto.QandAReplyDTO;
import kr.or.davizn.model.dto.QandAboardDTO;
import kr.or.davizn.service.QandAboard;

@Controller
public class QandAboardController {
	
	@Autowired
	private QandAboard QandAboardservice;
	
	//글목록보기
	@RequestMapping("QnAList.dvn")
	public String notices(String pg, Model model) throws ClassNotFoundException , SQLException {
		List<QandAboardDTO> list = QandAboardservice.notices(pg, model);
		
		model.addAttribute("list", list); 
		return "QnA.qna-list";
	}
    //글상세보기
	 @RequestMapping("/QnA/Qnadetail.dvn")
    public String noticeDetail(int boardseq , Model model ) throws ClassNotFoundException, SQLException{
		 System.out.println("상세 페이지 등장");
		 QandAboardDTO notice = QandAboardservice.noticeDetail(boardseq);
		 List<QandAReplyDTO> replylist =QandAboardservice.replyDetail(boardseq);
		 
		 model.addAttribute("replylist",replylist);
		 System.out.println(replylist);
		 model.addAttribute("notice", notice);
		 return "QnA.qna-detail";
	
	 }

	// 글등록 화면 처리
	 @RequestMapping(value="/QnA/qnaWrite.dvn", method = RequestMethod.GET)
	public String noticeReg() {
		 return  "QnA.qna-write";	   
	 }

	// 글등록 처리(실제 글등록 처리)
	 @RequestMapping(value = "/QnA/qnaWrite.dvn", method = RequestMethod.POST)
	public String noticeReg(QandAboardDTO dto, HttpServletRequest request)
	   throws IOException, ClassNotFoundException, SQLException {
		 String url = "redirect:qna-list";
		 try{
			 url = QandAboardservice.noticeReg(dto, request);
		 }catch(Exception e){
			System.out.println(e.getMessage()); 
		 }
		 
		 return url;
		
	 }

	// 글삭제하기
	 @RequestMapping("/QnA/QnaDel.dvn")
	public String noticeDel(String boardseq) throws ClassNotFoundException,
	   SQLException {
		String url = QandAboardservice.noticeDel(boardseq);
		System.out.println(url);
		return url; 
	 }
     
	 //글수정하기 (두가지 처리 : 화면(select) , 처리(update))
	 //글수정하기 (수정하기 화면 , 수정처리)
	 //주소같고 처리(GET , POST) 처리
	 @RequestMapping(value = "/QnA/QnAEdit.dvn", method = RequestMethod.GET)
	 public String noticeEdit(int boardseq, Model model)
	   throws ClassNotFoundException, SQLException {
		 QandAboardDTO notice = QandAboardservice.noticeEdit1(boardseq);
	    model.addAttribute("notice", notice);
	    return "QnA.qna-modify";
	 }

	 //게시판 실제 수정처리
	 @RequestMapping(value = "/QnA/QnAEdit.dvn", method = RequestMethod.POST)
	 public String noticeEdit(QandAboardDTO n ,HttpServletRequest request) throws ClassNotFoundException,
	   SQLException, IOException {
		 System.out.println("실제 에디트");
		 System.out.println("seq : " + n.getBoardseq());
		String url = QandAboardservice.noticeEdit2(n, request);
		System.out.println(url);
		return url;
	 }

}
