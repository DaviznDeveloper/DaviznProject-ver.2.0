package kr.or.davizn.groupService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupInterface.ManageVersionDAO;

@Service
public class VersionService {
	@Autowired
	SqlSession sqlsession;
	
	public int addVersion(VersionDTO versiondto){
		ManageVersionDAO versiondao = sqlsession.getMapper(ManageVersionDAO.class);
		System.out.println(versiondto.getGroupseq()+"/"+versiondto.getDataseq()+"/"+versiondto.getFilename()+"/"+versiondto.getComments()+"/"+versiondto.getUserid()+"/"+versiondto.getDataname());
		int result = versiondao.addverison(versiondto);
		return result;
	}
	
	public List<VersionDTO> getVersionlist(int dataseq){
		ManageVersionDAO versiondao = sqlsession.getMapper(ManageVersionDAO.class);
		return versiondao.getVersionlist(dataseq);
	}
}
