package kr.or.davizn.groupDTO;

import java.sql.Date;

public class GroupMemberDTO {

	private int g_memberseq;
	private int groupseq;
	private String userid;
	private Date joinindate;
	private String role_name;
	
	
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getG_memberseq() {
		return g_memberseq;
	}
	public void setG_memberseq(int g_memberseq) {
		this.g_memberseq = g_memberseq;
	}
	public int getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getJoinindate() {
		return joinindate;
	}
	public void setJoinindate(Date joinindate) {
		this.joinindate = joinindate;
	}
	
	
}
