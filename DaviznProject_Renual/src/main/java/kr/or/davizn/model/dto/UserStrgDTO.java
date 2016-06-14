package kr.or.davizn.model.dto;

import java.sql.Date;

public class UserStrgDTO {
	
	private int strgseq;
	private String strgname;
	private String userid;
	private Date strgcreate;
	
	public int getStrgseq() {
		return strgseq;
	}
	public void setStrgseq(int strgseq) {
		this.strgseq = strgseq;
	}
	public String getStrgname() {
		return strgname;
	}
	public void setStrgname(String strgname) {
		this.strgname = strgname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getStrgvreate() {
		return strgcreate;
	}
	public void setStrgvreate(Date strgcreate) {
		this.strgcreate = strgcreate;
	}
	
}
