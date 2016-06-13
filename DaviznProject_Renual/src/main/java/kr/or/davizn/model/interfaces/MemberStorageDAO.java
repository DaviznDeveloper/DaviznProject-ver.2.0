package kr.or.davizn.model.interfaces;

import java.util.List;

import kr.or.davizn.model.dto.MemberStorageDTO;

public interface MemberStorageDAO {
	public int addStorage(MemberStorageDTO MSdto);
	public int modifyStorageName(MemberStorageDTO MSdto);
	public List<MemberStorageDTO> showStorageList(String userid);
}
