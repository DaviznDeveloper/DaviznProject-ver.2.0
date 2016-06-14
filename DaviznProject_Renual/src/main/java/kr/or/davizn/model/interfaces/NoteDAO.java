package kr.or.davizn.model.interfaces;

import kr.or.davizn.model.dto.NoteDTO;

public interface NoteDAO {
	
	//노트 데이터 추가
	public int addNoteData(String filepath);
	//노트 데이터 추가 후 상세 조회
	public NoteDTO detailNoteData();

}
