package kr.or.davizn.groupInterface;

import java.util.List;


import kr.or.davizn.groupDTO.GroupAuthDTO;
import kr.or.davizn.groupDTO.GroupInfoDTO;
import kr.or.davizn.groupDTO.GroupMemberDTO;
import kr.or.davizn.memberDTO.AuthorityDTO;

public interface GroupInfoDAO {


	public int addGroup(GroupInfoDTO groupInfoDTO);
	
	//그룹 랜덤으로 5개 가져오기
	public List<GroupInfoDTO> randomGroupList();
	//검색한 그룹 리스트 가져오기
	public List<GroupInfoDTO> searchGroupList(String keyword);
	//방금 생성한 그룹의 고유번호 가져오기
	public int getGroupseq();
	//그룹원 수 가져오기
	public int getGMembercount(int groupseq);
	//그룹 데이터 수 가져오기
	public int getGDatacount(int groupseq);
	//그룹 추가시 groupinfo 테이블에 추가하기
	public int addGroupInfo(GroupInfoDTO groupInfoDTO);
	//그룹 추가 또는 멤버 가입시 groupmember 테이블에 추가하기
	public int addGroupMember(GroupMemberDTO groupMemberDTO);
	//그룹 생성시 해당 그룹의 권한 생성하여 groupauth 테이블에 추가
	public int addGroupAuth(GroupAuthDTO groupAuthDTO);
	//그룹 생성시 해당 그룹의 권한을 생성하여 auth 테이블에 추가
	public int addAuth(String role_name);
	//그룹 추가 또는 멤버 가입시 해당 user에게 맞는 권한 부여
	public int addAuthDesign(AuthorityDTO authorityDTO);
	//groupinfo 테이블의 값들을 list 타입으로 가져오기
	public List<GroupInfoDTO> getGroupList(String userid);
	//public int deleteGroup();
	//public int updateGroup();

}
