package kr.or.davizn.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.or.davizn.model.dto.DaviznMemberDTO;
import kr.or.davizn.model.interfaces.DaviznMemberDAO;

@Service
public class DaviznMemberService {
	
	@Autowired
	SqlSession sqlsession;
	
	//회원가입
	public int insertMember(DaviznMemberDTO member){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int result = dao.insertMember(member);	
		return result;
	}
	
	//닉네임 중복확인
	public String checkNickname(String nickname){
		System.out.println("checkNickname");
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int checkResult = dao.checkNickname(nickname);
		if(checkResult == 0) return "You can use this nickname";
		else return "You can't use this nickname. Alreay exist";
	}

	
	//이메일 중복확인
		public String checkMemberid(String memberid){
			DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
			int checkResult = dao.checkMemberid(memberid);
			if(checkResult == 0) return "You can use this memberid";
			else return "You can't use this memberid. Alreay exist";
		}
		
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
			 String fname = file.getOriginalFilename(); //파일명 얻기
			 String path  = request.getRealPath("/resources/upload");
			 String fullpath = path + "\\" + fname;
			 System.out.println("경로 테스트");
			 System.out.println(fullpath);
			 
			 if(!fname.equals("")){
				 //서버에 파일 쓰기 작업 
				  FileOutputStream fs = new FileOutputStream(fullpath);
				  fs.write(file.getBytes());
				  fs.close();
			  }
			 member.setProfile_img(fname);
			 member.setUserid(principal.getName());

		 }
		 System.out.println("멤버 아이디");
		 System.out.println("멤버 아이디 체크 : "+member.getUserid());
		int result = dao.updateMember(member);
		
		return result;
	}
}