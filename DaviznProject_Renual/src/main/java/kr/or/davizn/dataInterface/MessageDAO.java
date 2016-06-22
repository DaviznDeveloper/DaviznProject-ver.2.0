package kr.or.davizn.dataInterface;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.dataDTO.MessagesendDTO;
import kr.or.davizn.dataDTO.MessagereceiveDTO;

public interface MessageDAO {
	// 보낸 쪽지함 목록을 가져옴
	public List<MessagesendDTO> getSendMsgList(String userid) throws ClassNotFoundException, SQLException; 
	//받은 쪽지함 목록을 가져옴
	public List<MessagereceiveDTO> getReceiveMsgList(String userid) throws ClassNotFoundException, SQLException; 
	// 쪽지보내기에서 아이디 검색할 때 목록 가져오는 그거
	public List<DaviznMemberDTO> getMemberList(DaviznMemberDTO memberdto); 
	// 쪽지보낼 때 받는사람 userid을 가져오기 위한 메소드
	public DaviznMemberDTO getReceiverUserId(DaviznMemberDTO memberdto); 
	// 쪽지보내기 메소드(받은 쪽지함에 넣기)
	public void sendMessage_1(MessagesendDTO messagedto); 
	// 쪽지보내기 메소드(보낸 쪽지함에 넣기)
	public void sendMessage_2(MessagesendDTO messagedto); 
	// 보낸쪽지함에서 삭제하기
	public void deleteSendMessage(MessagesendDTO messagedto); 
	// 받은쪽지함에서 삭제하기
	public void deleteReceiverMessage(MessagesendDTO messagedto); 
	// 알림체크하기
	public List<MessagereceiveDTO> msgNotificationCheck(MessagereceiveDTO messagereceivedto) throws ClassNotFoundException, SQLException; 
	
	public void changeMsgNotificationState(MessagereceiveDTO messagereceivedto);
}



