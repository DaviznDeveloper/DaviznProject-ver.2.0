package kr.or.davizn.service;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.model.interfaces.PersonalDataDAO;
import kr.or.davizn.model.interfaces.UserStrgDAO;

@Service
public class PersonalData {
	@Autowired
	SqlSession sqlsession;
	
	//데이터 저장
	public int addPersonalData(PersonalDataDTO personaldto){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.addPersonalData(personaldto);
		return result;
	}
	
	
	//데이터 리스트 출력
	public List<PersonalDataDTO> showPersonalDataList(int strgseq){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		List<PersonalDataDTO> result = dao.showPersonalDataList(strgseq);
		return result;
	}
	
	//개인데이터 추가
	public String addPersonalData(PersonalDataDTO pdata,String inputArticleContents, 
			Principal principal, HttpServletRequest request) throws IOException{
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.addPersonalData(pdata);
		
		  String fname = principal.getName()+System.currentTimeMillis();
	      String endformat = ".txt";
	      String fpath = request.getRealPath("/resources/notefile");
	      String fullPath = fpath + "\\" + fname + endformat;
	      String fileName = fname+endformat;
	      System.out.println(fullPath);
	      FileWriter fw = new FileWriter(fullPath);
	      fw.write(inputArticleContents);
	      fw.close();
		
		return fileName;
	}
	
	//개인 데이터 삭제
	public int deleteNote(int dataseq){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result=dao.deletePersonalData(dataseq);
		return result;
	}
}
