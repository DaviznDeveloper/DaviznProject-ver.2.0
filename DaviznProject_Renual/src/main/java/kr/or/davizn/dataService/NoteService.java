package kr.or.davizn.dataService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.dataDTO.NoteDTO;
import kr.or.davizn.dataDTO.PersonalDataNoteDTO;
import kr.or.davizn.dataInterface.NoteDAO;

@Service
public class NoteService {

	@Autowired
	SqlSession sqlsession;

	// 노트 추가
	public int addNoteData(String filepath) {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		int result = dao.addNoteData(filepath);
		return result;

	}

	
	// 한 건의 노트 데이터 상세 보여주기
	@Transactional
	public PersonalDataNoteDTO detailNote(HttpServletRequest request, int dataseq) throws IOException {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		PersonalDataNoteDTO note = dao.detailNote(dataseq);

		String fname = note.getFilepath();
		String fpath = request.getRealPath("/resources/notefile");
		String fullPath = fpath + "\\" + fname;

		FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		// Buffer 장점 : Line 단위의 처리 가능(한줄씩 read 가능)

		String value = "";
		String newValue = "";

		for (int i = 1; (value = br.readLine()) != null; i++) {

			newValue += value;
		}

		br.close();
		fr.close();

		note.setValue(newValue);

		return note;
	}

	// 노트 데이터 파일 수정
	@Transactional
	public void modifyNoteFile(int dataseq, HttpServletRequest request, String inputArticleContents)
			throws IOException {
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		NoteDTO note = dao.selectOneNote(dataseq);
		String fpath = request.getRealPath("/resources/notefile");
		String fname = note.getFilepath();
		String fullPath = fpath + "\\" + fname;
		FileWriter fw = new FileWriter(fullPath);
		fw.write(inputArticleContents);
		fw.close();

	}


}
