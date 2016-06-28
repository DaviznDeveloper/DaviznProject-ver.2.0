package kr.or.davizn.datainfoDTO;

import java.sql.Date;

public class GroupDataDTO {
	/*
	 * DATASEQ	NUMBER
GROUPSEQ	NUMBER
DATATYPE	NUMBER
DATACREATE	DATE
USERID	VARCHAR2(50 BYTE)
DATANAME	VARCHAR2(200 BYTE)
	 * */
	private int dataseq;
	private int groupseq;
	private int datatype;
	private String userid;
	private String dataname;
	private Date datacreate;
	
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
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public Date getDatacreate() {
		return datacreate;
	}
	public void setDatacreate(Date datacreate) {
		this.datacreate = datacreate;
	}
	
	
	
	
}
