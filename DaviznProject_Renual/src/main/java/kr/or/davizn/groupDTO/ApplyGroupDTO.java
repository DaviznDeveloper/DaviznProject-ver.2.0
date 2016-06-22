package kr.or.davizn.groupDTO;

import java.sql.Date;

public class ApplyGroupDTO {
	/*G_APPLYSEQ	NUMBER
USERID	VARCHAR2(100 BYTE)
GROUPSEQ	NUMBER
APPLYDATE	DATE*/
	private int g_applyseq;
	private int groupseq;
	private String userid;
	private Date applydate;
	
	public int getG_applyseq() {
		return g_applyseq;
	}
	public void setG_applyseq(int g_applyseq) {
		this.g_applyseq = g_applyseq;
	}
	public int getGroupseq() {
		return groupseq;
	}
	public void setGroupseq(int groupseq) {
		this.groupseq = groupseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getApplydate() {
		return applydate;
	}
	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}
	
	
}
