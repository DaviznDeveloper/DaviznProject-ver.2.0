package kr.or.davizn.datasetDTO;

import java.sql.Date;

public class PersonalDataGoalDTO {
	
	private int dataseq;
	private int strgseq;
	private String dataname;
	private int datatype;
	private int detailcount;
	private Date datacreate;
	private Date startdate;
	private Date finaldate;
	private int goaldate;
	private int goalpercent;
	private int detailgoalseq;
	private String goalname;
	private int state;
	private String commentmsg;
	private String uesrid;
	private String origin;
	
	public String getUesrid() {
		return uesrid;
	}
	public void setUesrid(String uesrid) {
		this.uesrid = uesrid;
	}
	public int getGoaldate() {
		return goaldate;
	}
	public void setGoaldate(int goaldate) {
		this.goaldate = goaldate;
	}
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
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
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	public Date getDatacreate() {
		return datacreate;
	}
	public void setDatacreate(Date datacreate) {
		this.datacreate = datacreate;
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
	public int getDetailgoalseq() {
		return detailgoalseq;
	}
	public void setDetailgoalseq(int detailgoalseq) {
		this.detailgoalseq = detailgoalseq;
	}
	public String getGoalname() {
		return goalname;
	}
	public void setGoalname(String goalname) {
		this.goalname = goalname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCommentmsg() {
		return commentmsg;
	}
	public void setCommentmsg(String commentmsg) {
		this.commentmsg = commentmsg;
	}

	public int getDetailcount() {
		return detailcount;
	}
	public void setDetailcount(int detailcount) {
		this.detailcount = detailcount;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
}
