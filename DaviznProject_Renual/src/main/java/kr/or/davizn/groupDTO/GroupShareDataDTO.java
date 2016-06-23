package kr.or.davizn.groupDTO;

import java.sql.Date;

public class GroupShareDataDTO {

	private int share_dataseq;
	private int groupseq;
	private int dataseq;
	private String userid;
	private String dataname;
	private int datatype;
	private Date sharedate;
	
	public int getShare_dataseq() {
		return share_dataseq;
	}
	public void setShare_dataseq(int share_dataseq) {
		this.share_dataseq = share_dataseq;
	}
	public int getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
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
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	public Date getSharedate() {
		return sharedate;
	}
	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	

	
	
	
}
