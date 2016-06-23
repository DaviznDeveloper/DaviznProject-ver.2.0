package kr.or.davizn.dataDTO;

import java.sql.Date;

public class GoalListDTO {
	private int dataseq;
	private String goalname;
	private int detailcount;
	private Date finaldate;
	private int goalpercent;
	
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public String getGoalname() {
		return goalname;
	}
	public void setGoalname(String goalname) {
		this.goalname = goalname;
	}
	public int getDetailcount() {
		return detailcount;
	}
	public void setDetailcount(int detailcount) {
		this.detailcount = detailcount;
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
