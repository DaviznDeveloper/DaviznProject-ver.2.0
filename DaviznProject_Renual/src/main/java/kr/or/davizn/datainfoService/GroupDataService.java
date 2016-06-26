package kr.or.davizn.datainfoService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.datasetDTO.PersonalDataNoteDTO;

@Service
public class GroupDataService {
	
	@Autowired
	SqlSession sqlsession;
	
	public int getG_dataseq(int groupseq){
		/*int g_dataseq;
		GroupDataDAO groupDataDAO = sqlsession.getMapper(GroupDataDAO.class);
		g_dataseq = groupDataDAO.getG_dataseq(groupseq);
		return g_dataseq;*/
		return 0;
	}
	
	public int copyFile(HttpServletRequest request, String p_file, String g_file, int datatype) throws IOException{
		String fpath = null;
		if(datatype == 1) fpath = request.getRealPath("/resources/notefile");
		else if(datatype == 2) fpath = request.getRealPath("/resources/sketchfile");
		else if(datatype == 3) fpath = request.getRealPath("/resources/goalfile");
		else if(datatype == 4) fpath = request.getRealPath("/resources/schedulefile");

		FileInputStream inputStream = new FileInputStream(fpath+"\\"+p_file);         
		FileOutputStream outputStream = new FileOutputStream(fpath+"\\"+g_file);
		FileChannel fcin =  inputStream.getChannel();
		FileChannel fcout = outputStream.getChannel();

		long size = fcin.size();
		int result = fcin.transferTo(0, size, fcout) > 0 ? 1 : 0;
		fcout.close();
		fcin.close();
		outputStream.close();
		inputStream.close();
		
		return 0;
	}
	
	public void addGroupDataTable(GroupDataDTO groupdatadto){
		/*GroupDataDAO groupDataDAO = sqlsession.getMapper(GroupDataDAO.class);
		groupDataDAO.addGroupDataTable(groupdatadto);*/
	}
	
	public void addG_Note(PersonalDataNoteDTO notedto){
		/*GroupDataDAO groupDataDAO = sqlsession.getMapper(GroupDataDAO.class);
		groupDataDAO.addG_Note(notedto);*/
	}
	
	public List<GroupDataDTO> getG_ShareDatalist(int groupseq){
		/*GroupDataDAO groupDataDAO = sqlsession.getMapper(GroupDataDAO.class);
		return groupDataDAO.getG_ShareDatalist(groupseq);*/
		return null;
	}
}
