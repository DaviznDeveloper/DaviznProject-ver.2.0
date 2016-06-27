package kr.or.davizn.groupService;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.datainfoDTO.GroupDataDTO;
import kr.or.davizn.groupDTO.GroupAuthDTO;
import kr.or.davizn.groupDTO.GroupInfoDTO;
import kr.or.davizn.groupDTO.GroupListDTO;
import kr.or.davizn.groupDTO.GroupMemberDTO;
import kr.or.davizn.groupInterface.GroupInfoDAO;
import kr.or.davizn.memberDTO.AuthorityDTO;

@Service
public class GroupInfoService {
	
	@Autowired
	SqlSession sqlsession;
	
	//최근 groupseq
	public int getGroupseq(){
		int groupseq;
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		groupseq = groupInfoDAO.getGroupseq();
		return groupseq;
	}
	
	public GroupDataDTO getGroup(int dataseq){
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		return groupInfoDAO.getGroup(dataseq);
		
	}
	public void addGroupInfo(GroupInfoDTO groupInfoDTO){
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		groupInfoDAO.addGroupInfo(groupInfoDTO);	
	}
	

	public void addAuths(int groupseq){
		
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		String[] role_names = {"ROLE_"+groupseq+"_M","ROLE_"+groupseq+"_W","ROLE_"+groupseq+"_R"};

		for(String role_name:role_names){
			GroupAuthDTO groupAuthDTO = new GroupAuthDTO();
			groupAuthDTO.setGroupseq(groupseq);
			groupAuthDTO.setRole_name(role_name);
			groupInfoDAO.addGroupAuth(groupAuthDTO);
			groupInfoDAO.addAuth(role_name);

		}
	}
	
	public void addAuthDesign(AuthorityDTO authorityDTO){
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		groupInfoDAO.addAuthDesign(authorityDTO);
	}
	
	public List<GroupListDTO> getGroupList(String userid){
		GroupInfoDAO groupInfoDAO = sqlsession.getMapper(GroupInfoDAO.class);
		List<GroupListDTO> groupList = new ArrayList<GroupListDTO>();
		List<GroupInfoDTO> infoList = groupInfoDAO.getGroupList(userid);
		
		for(GroupInfoDTO dto:infoList){
			GroupListDTO grouplistdto = new GroupListDTO();
			int groupseq = dto.getGroupseq();

			grouplistdto.setGroupseq(groupseq);
			grouplistdto.setG_datacount(groupInfoDAO.getGDatacount(groupseq));
			grouplistdto.setG_goalcount(0);
			grouplistdto.setG_membercount(groupInfoDAO.getGMembercount(groupseq));
			grouplistdto.setGroupmaster(dto.getGroupmaster());
			grouplistdto.setGroupname(dto.getGroupname());
			groupList.add(grouplistdto);
		}
		System.out.println(groupList.size());
		return groupList;
	}
	
	
	//랜덤 그룹 리스트 출력
		public List<GroupInfoDTO> randomGroupList(){
			GroupInfoDAO ginfodao =  sqlsession.getMapper(GroupInfoDAO.class);
			List<GroupInfoDTO> randomList = ginfodao.randomGroupList();
			System.out.println("리스트 : "+randomList);
			return randomList;
		}
		
		//검색한 그룹 리스트 출력
		public List<GroupInfoDTO> searchGroupList(String keyword){
			GroupInfoDAO ginfodao =  sqlsession.getMapper(GroupInfoDAO.class);
			List<GroupInfoDTO> searchList = ginfodao.searchGroupList(keyword);
			return searchList;
		}
	

}
