package kr.or.davizn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.model.dto.NoteDTO;
import kr.or.davizn.model.dto.PersonalDataNoteDTO;
import kr.or.davizn.model.interfaces.NoteDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

@Service
public class NoteData {
	
	@Autowired
	SqlSession sqlsession;
	
	//노트 추가
	public int addNoteData(String filepath){
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		int result = dao.addNoteData(filepath);
		return result;
		
	}
	
	//노트 추가 후 상세 조회
	public PersonalDataNoteDTO detailNoteData(HttpServletRequest request) throws IOException{
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		///NoteDTO note = dao.detailNoteData();
		PersonalDataNoteDTO note =dao.detailNoteData();

		String fname = note.getFilepath();
	    String fpath = request.getRealPath("/resources/notefile");
	    String fullPath = fpath + "\\" + fname;
		
	    FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		//Buffer 장점 : Line 단위의 처리 가능(한줄씩 read 가능)
			
		String value="";
		String newValue="";
		String testvalue="테스트 el 뿌리기";
			for(int i =1 ; (value = br.readLine()) != null ; i++){
				
				newValue += value;
			}
			System.out.println("newvalue뿌리기 :"+newValue);
			
			br.close();
			fr.close(); 
			
			note.setValue(newValue);
			
		return note;
	}
	
	//목록에서 상세조회
	public PersonalDataNoteDTO detailNote(HttpServletRequest request,int dataseq) throws IOException{
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		///NoteDTO note = dao.detailNoteData();
		PersonalDataNoteDTO note =dao.detailNote(dataseq);

		String fname = note.getFilepath();
	    String fpath = request.getRealPath("/resources/notefile");
	    String fullPath = fpath + "\\" + fname;
		
	    FileReader fr = new FileReader(fullPath);
		BufferedReader br = new BufferedReader(fr);
		//Buffer 장점 : Line 단위의 처리 가능(한줄씩 read 가능)
			
		String value="";
		String newValue="";
		
			for(int i =1 ; (value = br.readLine()) != null ; i++){
				
				newValue += value;
			}
			System.out.println("newvalue뿌리기 :"+newValue);
			
			br.close();
			fr.close(); 
			
			note.setValue(newValue);
			
		return note;
	}
	
	//노트 데이터 삭제
	public int deleteNote(int dataseq){
		NoteDAO dao = sqlsession.getMapper(NoteDAO.class);
		int result = dao.deleteNote(dataseq);
		return result;
	}


}
