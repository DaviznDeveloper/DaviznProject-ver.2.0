package kr.or.davizn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.model.dto.MemberStorageDTO;
import kr.or.davizn.model.interfaces.MemberStorageDAO;

@Service
public class MemberStorage {
	@Autowired
	SqlSession sqlsession;
	
	//저장소 추가
	public int addStorage(MemberStorageDTO MSdto){
		MemberStorageDAO dao = sqlsession.getMapper(MemberStorageDAO.class);
		int result = dao.addStorage(MSdto);
		return result;
	}
	
	//저장소 이름 수정
	public int modifyStorageName(MemberStorageDTO MSdto){
		MemberStorageDAO dao = sqlsession.getMapper(MemberStorageDAO.class);
		int result = dao.modifyStorageName(MSdto);
		return result;
	}
	
	//저장소 리스트 출력
	public List<MemberStorageDTO> showStorageList(String userid){
		MemberStorageDAO dao = sqlsession.getMapper(MemberStorageDAO.class);
		List<MemberStorageDTO> result = dao.showStorageList(userid);
		return result;
	}
}
