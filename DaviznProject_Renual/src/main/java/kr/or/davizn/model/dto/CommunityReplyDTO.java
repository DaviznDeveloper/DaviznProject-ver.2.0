package kr.or.davizn.model.dto;

import java.sql.Date;

public class CommunityReplyDTO {
	private int replynum;
	private String replycontnet;
	private String userid;
	private int boardseq;
	private Date replydate;
	
	
	@Override
	public String toString() {
		return "CommunityReplyDTO [replynum=" + replynum + ", replycontnet=" + replycontnet + ", userid=" + userid
				+ ", boardseq=" + boardseq + ", replydate=" + replydate + "]";
	}


	public int getReplynum() {
		return replynum;
	}


	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}


	public String getReplycontnet() {
		return replycontnet;
	}


	public void setReplycontnet(String replycontnet) {
		this.replycontnet = replycontnet;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public int getBoardseq() {
		return boardseq;
	}


	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}


	public Date getReplydate() {
		return replydate;
	}


	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	
	
	
}
 