package kr.or.davizn.groupDTO;

import java.sql.Date;

public class GroupInfoDTO {

	private int groupseq;
	private String groupname;
	private String g_introduce;
	private String groupmaster;
	private Date groupcreate;
	
	public int getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getG_introduce() {
		return g_introduce;
	}
	public void setG_introduce(String g_introduce) {
		this.g_introduce = g_introduce;
	}
	public String getGroupmaster() {
		return groupmaster;
	}
	public void setGroupmaster(String groupmaster) {
		this.groupmaster = groupmaster;
	}
	public Date getGroupcreate() {
		return groupcreate;
	}
	public void setGroupcreate(Date groupcreate) {
		this.groupcreate = groupcreate;
	}
	
	
}
