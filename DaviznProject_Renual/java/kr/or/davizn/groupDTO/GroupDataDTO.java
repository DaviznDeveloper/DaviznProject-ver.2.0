package kr.or.davizn.groupDTO;

import java.sql.Date;

public class GroupDataDTO {
/*	DATASEQ	NUMBER
	GROUPSEQ	NUMBER
	DATATYPE	NUMBER
	G_DATACREATE	DATE
	USERID	VARCHAR2*/
	
	private int dataseq;
	private int groupseq;
	private int datatype;
	private String userid;
	private Date g_datacreate;
	
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public int getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getG_datacreate() {
		return g_datacreate;
	}
	public void setG_datacreate(Date g_datacreate) {
		this.g_datacreate = g_datacreate;
	}
	
}
