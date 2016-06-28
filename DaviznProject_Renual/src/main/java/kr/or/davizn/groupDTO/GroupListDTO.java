package kr.or.davizn.groupDTO;

public class GroupListDTO {
	//그룹이름
	//그룹장
	//그룹원 수
	//그룹 데이터 수
	//그룹 목표
	private int groupseq;
	private String groupname;
	private String groupmaster;
	private int g_membercount;
	private int g_datacount;
	private int g_goalcount;
	
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
	public String getGroupmaster() {
		return groupmaster;
	}
	public void setGroupmaster(String groupmaster) {
		this.groupmaster = groupmaster;
	}
	public int getG_membercount() {
		return g_membercount;
	}
	public void setG_membercount(int g_membercount) {
		this.g_membercount = g_membercount;
	}
	public int getG_datacount() {
		return g_datacount;
	}
	public void setG_datacount(int g_datacount) {
		this.g_datacount = g_datacount;
	}
	public int getG_goalcount() {
		return g_goalcount;
	}
	public void setG_goalcount(int g_goalcount) {
		this.g_goalcount = g_goalcount;
	}
	
	
	
}
