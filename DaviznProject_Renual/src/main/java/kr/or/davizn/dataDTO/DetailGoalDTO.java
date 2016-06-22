package kr.or.davizn.dataDTO;

public class DetailGoalDTO {

	
	private int detailgoalseq;
	private String goalname;
	private int state;
	private int dataseq;
	private String commentmsg;
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
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public String getCommentmsg() {
		return commentmsg;
	}
	public void setCommentmsg(String commentmsg) {
		this.commentmsg = commentmsg;
	}
	
	
}
