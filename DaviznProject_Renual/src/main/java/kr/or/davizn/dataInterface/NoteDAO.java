package kr.or.davizn.dataInterface;

import kr.or.davizn.dataDTO.NoteDTO;
import kr.or.davizn.dataDTO.PersonalDataNoteDTO;

public interface NoteDAO {
	
	//노트 데이터 추가
	public int addNoteData(String filepath);
	//목록에서 데이터 상세 조회
	public PersonalDataNoteDTO detailNote(int dataseq);

	//파일 overwrite를 위하여 노트 가져오기
	public NoteDTO selectOneNote(int dataseq);

}
