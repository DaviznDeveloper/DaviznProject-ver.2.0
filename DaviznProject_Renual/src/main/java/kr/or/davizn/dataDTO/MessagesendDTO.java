package kr.or.davizn.dataDTO;

import java.sql.Date;

public class MessagesendDTO {
	
	private int message_num;
	private String receiver;
	private String message_title;
	private String message_content;
	private Date message_date;
	private String sender;
	
	

	@Override
	public String toString() {
		return "MessagesendDTO [message_num=" + message_num + ", receiver=" + receiver + ", message_title="
				+ message_title + ", message_content=" + message_content + ", message_date=" + message_date
				+ ", sender=" + sender + "]";
	}

	public int getMessage_num() {
		return message_num;
	}

	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	

	
	
}
