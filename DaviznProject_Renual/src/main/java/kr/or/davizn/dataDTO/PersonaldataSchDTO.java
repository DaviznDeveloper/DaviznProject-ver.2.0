package kr.or.davizn.dataDTO;

import java.sql.Date;

public class PersonaldataSchDTO {

	private int dataseq;
	private int datatype;
	private String schname;
	private String schcontext;
	private String startdate;
	private String finaldate;
	private String alramdate;
	private int priority;
	private int state;
	private int strgseq;
	private String dataname;
	private Date datacreate;
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	public String getSchname() {
		return schname;
	}
	public void setSchname(String schname) {
		this.schname = schname;
	}
	public String getSchcontext() {
		return schcontext;
	}
	public void setSchcontext(String schcontext) {
		this.schcontext = schcontext;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getFinaldate() {
		return finaldate;
	}
	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}
	public String getAlramdate() {
		return alramdate;
	}
	public void setAlramdate(String alramdate) {
		this.alramdate = alramdate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getStrgseq() {
		return strgseq;
	}
	public void setStrgseq(int strgseq) {
		this.strgseq = strgseq;
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
