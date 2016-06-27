package kr.or.davizn.groupService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.ApplyGroupDTO;
import kr.or.davizn.groupInterface.ApplyGroupDAO;

@Service
public class ApplyGroupService {
	
	@Autowired
	SqlSession sqlsession;
	
	public int checkMember(ApplyGroupDTO applydto){
		ApplyGroupDAO applydao = sqlsession.getMapper(ApplyGroupDAO.class);
		return applydao.checkMember(applydto);
	}
	
	public void addGroupMember(ApplyGroupDTO applydto){
		ApplyGroupDAO applydao = sqlsession.getMapper(ApplyGroupDAO.class);
		applydao.addApplyMember(applydto);
	}
	
	public List<ApplyGroupDTO> showApplylist(int groupseq){
		ApplyGroupDAO applydao = sqlsession.getMapper(ApplyGroupDAO.class);
		return applydao.getApplylist(groupseq);
	}
	
	public void deleteApply(ApplyGroupDTO applydto){
		ApplyGroupDAO applydao = sqlsession.getMapper(ApplyGroupDAO.class);
		applydao.deleteApply(applydto);
	}
}
