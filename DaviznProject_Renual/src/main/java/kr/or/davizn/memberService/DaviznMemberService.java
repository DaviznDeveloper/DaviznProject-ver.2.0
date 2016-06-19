package kr.or.davizn.memberService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberInterface.DaviznMemberDAO;

@Service
public class DaviznMemberService {
	
	@Autowired
	SqlSession sqlsession;
	

		
	//회원정보 수정(기존 정보 검색)
	public DaviznMemberDTO selectOneMember(String userid){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		DaviznMemberDTO member = dao.selectOneMember(userid);
		return member;
	}
	
	//회원정보 수정(회원정보 수정)
	public int updateMember(DaviznMemberDTO member, HttpServletRequest request, Principal principal) throws IOException{
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		CommonsMultipartFile file = member.getUploadImage();
		 if(file != null){
			 
			 String fname = System.currentTimeMillis()+file.getOriginalFilename(); //파일명 얻기
			 String path  = request.getRealPath("/resources/upload");
			 String fullpath = path + "\\" + fname;
			
			 
			 if(!fname.equals("")){
				 //서버에 파일 쓰기 작업 
				  FileOutputStream fs = new FileOutputStream(fullpath);
				  fs.write(file.getBytes());
				  fs.close();
			  }
			 member.setProfile_img(fname);
			 member.setUserid(principal.getName());

		 }
		
		int result = dao.updateMember(member);
		
		return result;
	}
}