package kr.or.davizn.dataDTO;

import java.sql.Date;

public class MessagereceiveDTO {
	
	private int message_num;
	private String sender;
	private String message_title;
	private String message_content;
	private Date message_date;
	private int msg_alarm;
	private String receiver;
	
	
	


	public String getReceiver() {
		return receiver;
	}


	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}


	public int getMessage_num() {
		return message_num;
	}


	@Override
	public String toString() {
		return "MessagereceiveDTO [message_num=" + message_num + ", sender=" + sender + ", message_title="
				+ message_title + ", message_content=" + message_content + ", message_date=" + message_date
				+ ", msg_alarm=" + msg_alarm + ", receiver=" + receiver + "]";
	}


	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getMessage_title() {
		return message_title;
	}


	public void setMessage_title(String message_title) {
		this.message_title = message_title;
	}


	public String getMessage_content() {
		return message_content;
	}


	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}


	public Date getMessage_date() {
		return message_date;
	}


	public void setMessage_date(Date message_date) {
		this.message_date = message_date;
	}


	public int getMsg_alarm() {
		return msg_alarm;
	}


	public void setMsg_alarm(int msg_alarm) {
		this.msg_alarm = msg_alarm;
	}


	
	
	
	
	   
}
