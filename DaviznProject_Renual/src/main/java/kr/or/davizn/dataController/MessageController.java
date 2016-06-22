package kr.or.davizn.dataController;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.dataInterface.MessageDAO;
import kr.or.davizn.dataDTO.MessagereceiveDTO;
import kr.or.davizn.dataDTO.MessagesendDTO;
import kr.or.davizn.memberDTO.DaviznMemberDTO;


@Controller
@RequestMapping("/message/")
public class MessageController {
	
	@Autowired
	private SqlSession sqlsession;
	
	//보낸 쪽지함 목록을 가져옴 
	//받은 쪽지함 목록을 가져옴
	/*@RequestMapping("message.dvn")
	public ModelAndView message(DaviznMemberDTO memberdto) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		ModelAndView mav = new ModelAndView("/message/message");
		mav.addObject("smlist", dao.getSendMsgList(map));
		mav.addObject("rmlist", dao.getReceiveMsgList(memberdto));

		return mav;
	}*/
	
	
	
	@RequestMapping("message.dvn")
	public String message( Model model, Principal principal) throws ClassNotFoundException, SQLException{
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		System.out.println(dao);
		String userid = principal.getName();
		model.addAttribute("smlist", dao.getSendMsgList(userid));
		model.addAttribute("rmlist", dao.getReceiveMsgList(userid));
		
		return "message.message";
	}
	
	
	
	
	//쪽지보내기에서 아이디 검색할 때 목록 가져오는 그거
	@RequestMapping("getMemberList.dvn")
	public @ResponseBody List<DaviznMemberDTO> getMemberList(DaviznMemberDTO memberdto) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		System.out.println(dao);
		return dao.getMemberList(memberdto);
	}
	
	//쪽지보낼 때 받는사람 userid을 가져오기 위한 메소드  
	@RequestMapping("getReceiverUserId.dvn")
	public @ResponseBody DaviznMemberDTO getReceiverUserId(DaviznMemberDTO memberdto) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		return dao.getReceiverUserId(memberdto);
	}
	
	//쪽지보내기 메소드(받은 쪽지함에 넣기) 
	//쪽지보내기 메소드(보낸 쪽지함에 넣기)
	@RequestMapping("sendMessage.dvn")
	public String sendMessage(MessagesendDTO messagedto, HttpSession session) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		dao.sendMessage_1(messagedto);
		dao.sendMessage_2(messagedto);
		return "redirect:/message/message.dvn?userid=" + session.getAttribute("userid");
	}
	
	//보낸쪽지함에서 삭제하기
	@RequestMapping("deleteSendMessage.dvn")
	public String deleteSendMessage(MessagesendDTO messagedto, HttpSession session) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		dao.deleteSendMessage(messagedto);
		return "redirect:/message/message.dvn?userid=" + session.getAttribute("userid");
	}
	
	//받은쪽지함에서 삭제하기
	@RequestMapping("deleteReceiveMessage.dvn")
	public String deleteReceiveMessage(MessagesendDTO messagedto, HttpSession session) {
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		dao.deleteReceiverMessage(messagedto);
		return "redirect:/message/message.dvn?userid=" + session.getAttribute("userid");
	}
	
	//알림체크하기
	@RequestMapping("msgNotificationCheck.dvn")
	public @ResponseBody List<MessagereceiveDTO> msgNotificationCheck(MessagereceiveDTO messagereceivedto) throws ClassNotFoundException, SQLException {
		
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		
		return dao.msgNotificationCheck(messagereceivedto);
	}
	
	@RequestMapping("changeMsgNotificationState.dvn")
	public void changeNotificationStates(MessagereceiveDTO messagereceivedto) {
		System.out.println("changeMsgNotificationState");
		MessageDAO dao = sqlsession.getMapper(MessageDAO.class);
		dao.changeMsgNotificationState(messagereceivedto);
	}
}


































