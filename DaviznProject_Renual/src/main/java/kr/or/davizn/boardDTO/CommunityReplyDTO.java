package kr.or.davizn.boardDTO;

import java.sql.Date;

public class CommunityReplyDTO {
	private int replynum;
	private String userid;
	private String replycontent;
	private int boardseq;
	private Date replydate;
		
	@Override
	public String toString() {
		return "QandAReplyDTO [replynum=" + replynum + ", userid=" + userid + ", replycontent=" + replycontent
				+ ", boardseq=" + boardseq + ", replydate=" + replydate + "]";
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
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
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
