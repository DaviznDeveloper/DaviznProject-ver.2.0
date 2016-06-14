package kr.or.davizn.model.dto;

import java.sql.Date;

public class QandAReplyDTO {
	private int replynum;
	private String userid;
	private String replycontnet;
	private int boardseq;
	private Date replydate;
	
	
	@Override
	public String toString() {
		return "QandAReplyDTO [replynum=" + replynum + ", userid=" + userid + ", replycontnet=" + replycontnet
				+ ", boardseq=" + boardseq + ", replydate=" + replydate + "]";
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReplycontnet() {
		return replycontnet;
	}
	public void setReplycontnet(String replycontnet) {
		this.replycontnet = replycontnet;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}
	
}
