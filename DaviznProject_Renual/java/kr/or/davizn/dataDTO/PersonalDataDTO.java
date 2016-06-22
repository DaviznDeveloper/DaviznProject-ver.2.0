package kr.or.davizn.dataDTO;

import java.sql.Date;

public class PersonalDataDTO {
	
	private int dataseq;
	private int strgseq;
	private String dataname;
	private int datatype;
	private Date datacreate;
	private String ckeditor;
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
	public String getCkeditor() {
		return ckeditor;
	}
	public void setCkeditor(String ckeditor) {
		this.ckeditor = ckeditor;
	}
	
	
	
	
}
