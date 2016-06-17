package kr.or.davizn.dataDTO;

import java.sql.Date;

public class GoalDTO {
	
	private int dataseq;
	private int datatype;
	private Date startdate;
	private Date finaldate;
	private int goalpercent;
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getFinaldate() {
		return finaldate;
	}
	public void setFinaldate(Date finaldate) {
		this.finaldate = finaldate;
	}
	public int getGoalpercent() {
		return goalpercent;
	}
	public void setGoalpercent(int goalpercent) {
		this.goalpercent = goalpercent;
	}
	
	
	
	
}
