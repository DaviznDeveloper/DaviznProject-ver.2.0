package kr.or.davizn.model.interfaces;

import kr.or.davizn.model.dto.NoteDTO;
import kr.or.davizn.model.dto.PersonalDataNoteDTO;

public interface NoteDAO {
	
	//노트 데이터 추가
	public int addNoteData(String filepath);
	//노트 데이터 추가 후 상세 조회
	/*public NoteDTO detailNoteData();*/
	public PersonalDataNoteDTO detailNoteData();
	//목록에서 데이터 상세 조회
	public PersonalDataNoteDTO detailNote(int dataseq);
	//상세 페이지 노트 삭제
	public int deleteNote(int dataseq);
	

}
