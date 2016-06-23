package kr.or.davizn.dataService;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataInterface.GoalDAO;
import kr.or.davizn.dataInterface.PersonalDataDAO;

@Service
public class PersonalService {
	@Autowired
	SqlSession sqlsession;

	// 방금 추가한 목표의 dataseq 가져오기
	public int getDataseq(int strgseq) {
		PersonalDataDAO personalDAO = sqlsession.getMapper(PersonalDataDAO.class);
		int dataseq = personalDAO.getDataseq(strgseq);
		return dataseq;
	}

	// 데이터 저장. personaldata 테이블에 저장하기.
	public int addPersonalData(PersonalDataDTO personaldto) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);

		//
		int result = dao.addPersonalData(personaldto);
		return result;
	}

	// 개인데이터 추가시. 모든 형에 해당
	// file name 생성, file 내용 완성.
	@Transactional
	public String getFileName(PersonalDataDTO pdata, String inputArticleContents, Principal principal,
			HttpServletRequest request) throws IOException {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		String fpath = "";
		if(pdata.getDatatype() == 1) fpath = request.getRealPath("/resources/notefile");
		else if(pdata.getDatatype() == 2) fpath = request.getRealPath("/resources/sketchfile");
		else if(pdata.getDatatype() == 3) fpath = request.getRealPath("/resources/goalfile");
		else if(pdata.getDatatype() == 4) fpath = request.getRealPath("/resources/schedulefile");
		String fname = principal.getName() + System.currentTimeMillis();
		String endformat = ".txt";
		String fullPath = fpath + "\\" + fname + endformat;
		String fileName = fname + endformat;
		FileWriter fw = new FileWriter(fullPath);
		fw.write(inputArticleContents);
		fw.close();

		return fileName;
	}
	
	//처음 데이터 생성시 managefile 테이블에 추가
	public void manageFile(int dataseq, String filepath){
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		dao.manageFile(dataseq, filepath);
	}
	
	// 데이터 리스트 출력
	public List<PersonalDataDTO> showPersonalDataList(int strgseq) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		List<PersonalDataDTO> result = dao.showPersonalDataList(strgseq);
		return result;
	}

	// 개인데이터 수정
	public int updatePersonaldata(int dataseq, String dataname) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.updatePersonaldata(dataname, dataseq);
		return result;
	}

	// 개인 데이터 삭제
	public int deleteNote(int dataseq) {
		PersonalDataDAO dao = sqlsession.getMapper(PersonalDataDAO.class);
		int result = dao.deletePersonalData(dataseq);
		return result;
	}
}
