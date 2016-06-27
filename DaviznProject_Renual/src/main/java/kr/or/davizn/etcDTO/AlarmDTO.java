package kr.or.davizn.etcDTO;

import java.sql.Date;

public class AlarmDTO {
	private int alarmseq; //알람 시퀀스
	private int dataseq; //데이터 고유 번호
	private int datatype; //데이터 타입
	private String dataname;//데이터 제목
	private int checkedstate;//데이터 체크 여부
	private Date finaldate;//종료일
	private Date alarmdate;//지정 알람일 
	private int strgseq;//저장소 시퀀스(이 값으로 사용자의 알람 가져옴)
	
	
	public int getStrgseq() {
		return strgseq;
	}
	public void setStrgseq(int strgseq) {
		this.strgseq = strgseq;
	}
	public int getAlarmseq() {
		return alarmseq;
	}
	public void setAlarmseq(int alarmseq) {
		this.alarmseq = alarmseq;
	}
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
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public int getCheckedstate() {
		return checkedstate;
	}
	public void setCheckedstate(int checkedstate) {
		this.checkedstate = checkedstate;
	}
	public Date getFinaldate() {
		return finaldate;
	}
	public void setFinaldate(Date finaldate) {
		this.finaldate = finaldate;
	}
	public Date getAlarmdate() {
		return alarmdate;
	}
	public void setAlarmdate(Date alarmdate) {
		this.alarmdate = alarmdate;
	}
	@Override
	public String toString() {
		return "AlarmDTO [alarmseq=" + alarmseq + ", dataseq=" + dataseq + ", datatype=" + datatype + ", dataname="
				+ dataname + ", checkedstate=" + checkedstate + ", finaldate=" + finaldate + ", alarmdate=" + alarmdate
				+ ", strgseq=" + strgseq + "]";
	}
	
	
	
}
