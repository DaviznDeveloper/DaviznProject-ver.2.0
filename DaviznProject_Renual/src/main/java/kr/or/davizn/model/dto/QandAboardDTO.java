package kr.or.davizn.model.dto;

import java.sql.Date;

public class QandAboardDTO {
	private String boardsubject;// 제목
	private String boardpwd;// 글 비밀번호
	private String boardcontent;// 내용
	private Date boarddate;// 작성일
	private int boardreadcount;// 조회수
	private int boardseq;// 순서
	private String boardnotice;// 공지
	private String userid;// 회원아이디(이메일)

	public String getBoardsubject() {
		return boardsubject;
	}

	public void setBoardsubject(String boardsubject) {
		this.boardsubject = boardsubject;
	}

	public String getBoardpwd() {
		return boardpwd;
	}

	public void setBoardpwd(String boardpwd) {
		this.boardpwd = boardpwd;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public int getBoardreadcount() {
		return boardreadcount;
	}

	public void setBoardreadcount(int boardreadcount) {
		this.boardreadcount = boardreadcount;
	}

	public int getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}

	public String getBoardnotice() {
		return boardnotice;
	}

	public void setBoardnotice(String boardnotice) {
		this.boardnotice = boardnotice;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "QandAboardDTO [boardsubject=" + boardsubject + ", boardpwd=" + boardpwd + ", boardcontent="
				+ boardcontent + ", boarddate=" + boarddate + ", boardreadcount=" + boardreadcount + ", boardseq="
				+ boardseq + ", boardnotice=" + boardnotice + ", userid=" + userid + "]";
	}
	

}