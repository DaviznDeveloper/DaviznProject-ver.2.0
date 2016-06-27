package kr.or.davizn.datasetService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetInterface.NoteDAO;

@Service
public class NoteService {

	@Autowired
	SqlSession sqlsession;

	// 노트 추가
	public int addNoteData(PersonalDataNoteDTO notedto) {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		int result = dao.addNoteData(notedto);
		return result;

	}

	
	// 한 건의 노트 데이터 상세 보여주기
	@Transactional
	public PersonalDataNoteDTO detailNote(HttpServletRequest request, int dataseq) throws IOException {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		PersonalDataNoteDTO note = dao.detailPNote(dataseq);
		if(note == null){note = dao.detailGNote(dataseq);}
		String fname = note.getFilepath();
		System.out.println("fname : " + fname);
		String fpath = request.getRealPath("/resources/notefile");
		String fullPath = fpath + "\\" + fname;
		FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		String value = "";
		String datahtml = "";

		for (int i = 1; (value = br.readLine()) != null; i++) {

			datahtml += value;
		}

		br.close();
		fr.close();

		note.setDatahtml(datahtml);

		return note;
	}

	/*@Transactional
	public PersonalDataNoteDTO detailGNote(HttpServletRequest request, int dataseq) throws IOException {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		PersonalDataNoteDTO note = dao.detailGNote(dataseq);
		String fname = note.getFilepath();
		System.out.println("fname : " + fname);
		String fpath = request.getRealPath("/resources/notefile");
		String fullPath = fpath + "\\" + fname;
		FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		String value = "";
		String datahtml = "";

		for (int i = 1; (value = br.readLine()) != null; i++) {

			datahtml += value;
		}

		br.close();
		fr.close();

		note.setDatahtml(datahtml);

		return note;
	}*/
	
	
	// 노트 데이터 파일 수정
	@Transactional
	public void modifyNoteFile(int dataseq, HttpServletRequest request, String datahtml)
			throws IOException {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		PersonalDataNoteDTO note = dao.detailPNote(dataseq);
		if(note==null){note = dao.detailGNote(dataseq);}
		String fpath = request.getRealPath("/resources/notefile");
		String fname = note.getFilepath();
		String fullPath = fpath + "\\" + fname;
		FileWriter fw = new FileWriter(fullPath);
		fw.write(datahtml);
		fw.close();

	}

	

}
