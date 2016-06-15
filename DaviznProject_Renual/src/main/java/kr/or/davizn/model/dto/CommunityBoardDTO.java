package kr.or.davizn.model.dto;

import java.sql.Date;

import oracle.sql.DATE;

public class CommunityBoardDTO {

      private int boardseq;         //글번호
      private String userid;   		//회원 아이디(이메일)
      private String boardsubject;  //제목
      private String boardcontent;	//내용
      private Date boarddate;    	//작성일
      private int boardreadcount;   //조회수
      private int boardref;         //답변정렬
      private int boardlev;         //들여쓰기
      private int boardorder;		//순서
      private String boardnotice;   //공지
	@Override
	public String toString() {
		return "CommunityBoardDTO [boardseq=" + boardseq + ", userid=" + userid + ", boardsubject=" + boardsubject
				+ ", boardcontent=" + boardcontent + ", boarddate=" + boarddate + ", boardreadcount=" + boardreadcount
				+ ", boardref=" + boardref + ", boardlev=" + boardlev + ", boardorder=" + boardorder + ", boardnotice="
				+ boardnotice + "]";
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBoardsubject() {
		return boardsubject;
	}
	public void setBoardsubject(String boardsubject) {
		this.boardsubject = boardsubject;
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
	public int getBoardref() {
		return boardref;
	}
	public void setBoardref(int boardref) {
		this.boardref = boardref;
	}
	public int getBoardlev() {
		return boardlev;
	}
	public void setBoardlev(int boardlev) {
		this.boardlev = boardlev;
	}
	public int getBoardorder() {
		return boardorder;
	}
	public void setBoardorder(int boardorder) {
		this.boardorder = boardorder;
	}
	public String getBoardnotice() {
		return boardnotice;
	}
	public void setBoardnotice(String boardnotice) {
		this.boardnotice = boardnotice;
	}
     
      
     
}