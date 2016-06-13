package kr.or.davizn.model.dto;

public class DataValuesDTO {
	private int data_no;
	private int rowpoint;
	private int colpoint;
	private String value;
	public int getData_no() {
		return data_no;
	}
	public void setData_no(int data_no) {
		this.data_no = data_no;
	}
	public int getRowpoint() {
		return rowpoint;
	}
	public void setRowpoint(int rowpoint) {
		this.rowpoint = rowpoint;
	}
	public int getColpoint() {
		return colpoint;
	}
	public void setColpoint(int colpoint) {
		this.colpoint = colpoint;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
