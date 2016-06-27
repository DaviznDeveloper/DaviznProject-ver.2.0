package kr.or.davizn.groupDTO;

import java.sql.Date;

public class VersionDTO {
/*VERSIONSEQ	NUMBER
GROUPSEQ	NUMBER
DATASEQ	NUMBER
FILENAME	VARCHAR2(300 BYTE)
MODIFYTIME	DATE*/
	private int versionseq;
	private int groupseq;
	private int dataseq;
	private String filename;
	private Date modifytime;
	private String Comments;
	
	
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public int getVersionseq() {
		return versionseq;
	}
	public void setVersionseq(int versionseq) {
		this.versionseq = versionseq;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getModifytime() {
		return modifytime;
	}
	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
	
	
}
