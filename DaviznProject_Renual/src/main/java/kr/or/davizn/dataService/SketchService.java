package kr.or.davizn.dataService;

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

import kr.or.davizn.dataDTO.PersonalDataSketchDTO;
import kr.or.davizn.dataInterface.SketchDAO;

@Service
public class SketchService {
	
	@Autowired
	SqlSession sqlsession;
	
	//스케치 데이터 만들기
	public String writeSketchData(int strgseq, String dataname,
						Principal principal,HttpServletRequest request,
						String sketchData) throws IOException{
		//개인 저장소 추가
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		int presult = sketchdao.addPersonalSketch(strgseq, dataname);
		
		String fname = principal.getName() + System.currentTimeMillis();
		String endformat = ".txt";
		String fpath = request.getRealPath("/resources/sketchfile");
		String fullPath = fpath + "\\" + fname + endformat;
		String fileName = fname + endformat;

		FileWriter fw = new FileWriter(fullPath);
		fw.write(sketchData);
		fw.close();

		return fileName;
		
	}
	//스케치 데이터 추가
	public int addSketchData(String filepath){
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		int result = sketchdao.addSketch(filepath);
		return result;
	}
	
	//스케치 데이터의 파일 이름 가져오기
	public PersonalDataSketchDTO detailSketch(int dataseq,HttpServletRequest request) 
			throws IOException{
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		PersonalDataSketchDTO sketch = sketchdao.detailSketch(dataseq);
		String fname = sketch.getFilepath();
		String fpath = request.getRealPath("/resources/sketchfile");
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

		sketch.setValue(newValue);

		return sketch;
		
		
	}
	
	//스케치 데이터 삭제
	public int deleteSketch(int dataseq){
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		int result = sketchdao.deleteSketch(dataseq);
		return result;
	}
	
	//스케치 데이터 데이터 제목 수정
	public void updateSketchAction(String dataname, int dataseq,
			String sketchData,HttpServletRequest request) 
					throws IOException{
		SketchDAO sketchdao = sqlsession.getMapper(SketchDAO.class);
		//데이터 제목 수정
		int renameResult = sketchdao.updateDataName(dataname, dataseq);
		String filePath = sketchdao.getFilePath(dataseq);
		/*
		 * 
		 * String fname = principal.getName() + System.currentTimeMillis();
		String endformat = ".txt";
		String fpath = request.getRealPath("/resources/sketchfile");
		String fullPath = fpath + "\\" + fname + endformat;
		String fileName = fname + endformat;

		FileWriter fw = new FileWriter(fullPath);
		fw.write(sketchData);
		fw.close();
		 * */
		
		String fpath=request.getRealPath("/resources/sketchfile");
		String fullpath = fpath+"\\"+filePath;
		FileWriter fw = new FileWriter(fullpath);
		fw.write(sketchData);
		fw.close();
		
	}
	
	
}
