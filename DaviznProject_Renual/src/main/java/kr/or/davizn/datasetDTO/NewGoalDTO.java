package kr.or.davizn.datasetDTO;

public class NewGoalDTO {
	private String dataname;
	private String[] detailnames;
	private String startdate;
	private String finaldate;
	private String origin;
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String[] getDetailnames() {
		return detailnames;
	}
	public void setDetailnames(String[] detailnames) {
		this.detailnames = detailnames;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	

}
