package kr.or.davizn.datasetService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;
import kr.or.davizn.datasetDTO.PersonalDataSketchDTO;
import kr.or.davizn.datasetInterface.NoteDAO;
import kr.or.davizn.datasetInterface.SketchDAO;

@Service
public class SketchService {
	
	@Autowired
	SqlSession sqlsession;

	//스케치 데이터 추가
	public int addSketchData(String filepath){
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		int result = sketchdao.addSketch(filepath);
		return result;
	}
	
	
	//스케치 한 건의 데이터 상세 보여주기
	public PersonalDataSketchDTO detailSketch(int dataseq,HttpServletRequest request) 
			throws IOException{
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		PersonalDataSketchDTO sketch = sketchdao.detailSketch(dataseq);
		String fname = sketch.getFilepath();
		String fpath = request.getRealPath("/resources/sketchfile");
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
		sketch.setDatahtml(datahtml);
		return sketch;
	}
	
	//스케치 데이터 수정
	public void modifySketch(int dataseq,
							HttpServletRequest request, String datahtml) 
					throws IOException{
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		PersonalDataSketchDTO sketch = sketchdao.detailSketch(dataseq);
		String fpath = request.getRealPath("/resources/sketchfile");
		String fname = sketch.getFilepath();
		String fullPath = fpath + "\\" + fname;
		FileWriter fw = new FileWriter(fullPath);
		fw.write(datahtml);
		fw.close();
	}
	
	
}
