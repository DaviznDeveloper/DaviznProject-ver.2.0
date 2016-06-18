package kr.or.davizn.dataInterface;

import kr.or.davizn.dataDTO.NoteDTO;
import kr.or.davizn.dataDTO.PersonalDataNoteDTO;

public interface NoteDAO {
	
	//노트 데이터 추가
	public int addNoteData(String filepath);
	//노트 데이터 추가 후 상세 조회
	/*public NoteDTO detailNoteData();*/
	public PersonalDataNoteDTO detailNoteData();
	//목록에서 데이터 상세 조회
	public PersonalDataNoteDTO detailNote(int dataseq);
	//노트 데이터 수정(기존 정보 확인)
	public PersonalDataNoteDTO modifyNote(int dataseq);
	//파일 overwrite를 위하여 노트 가져오기
	public NoteDTO selectOneNote(int dataseq);
	//상세 페이지 노트 삭제
	public int deleteNote(int dataseq);
	

}
