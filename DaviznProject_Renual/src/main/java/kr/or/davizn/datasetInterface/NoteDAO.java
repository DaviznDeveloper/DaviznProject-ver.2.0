package kr.or.davizn.datasetInterface;

import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;

public interface NoteDAO {
	
	//노트 데이터 추가
	public int addNoteData(PersonalDataNoteDTO notedto);
	//목록에서 데이터 상세 조회
	public PersonalDataNoteDTO detailPNote(int dataseq);
	//목록에서 데이터 상세 조회
	public PersonalDataNoteDTO detailGNote(int dataseq);
}
