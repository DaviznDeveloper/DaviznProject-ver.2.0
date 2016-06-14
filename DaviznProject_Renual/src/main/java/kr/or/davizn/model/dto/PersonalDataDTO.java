package kr.or.davizn.model.dto;

import java.sql.Date;

public class PersonalDataDTO {
	public int dataseq;
	public int strgseq;
	public String dataname;
	public int datatype;
	public Date datacreate;
	
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
	
	
}
