package kr.or.davizn.datainfoDTO;

import java.sql.Date;

public class GroupDataDTO {

	private int g_dataseq;
	private int dataseq;
	private int groupseq;
	private int datatype;
	private String userid;
	private String dataname;
	private String origin;
	private Date g_datacreate;
	public int getG_dataseq() {
		return g_dataseq;
	}
	public void setG_dataseq(int g_dataseq) {
		this.g_dataseq = g_dataseq;
	}
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Date getG_datacreate() {
		return g_datacreate;
	}
	public void setG_datacreate(Date g_datacreate) {
		this.g_datacreate = g_datacreate;
	}
	
	
	
	
}
