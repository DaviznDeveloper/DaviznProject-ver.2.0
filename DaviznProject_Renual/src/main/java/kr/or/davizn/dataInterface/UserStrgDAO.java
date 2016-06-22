package kr.or.davizn.dataInterface;

import java.util.List;

import kr.or.davizn.dataDTO.UserStrgDTO;

public interface UserStrgDAO {
	public int addStorage(String strgname, String userid);
	public int modifyStorageName(UserStrgDTO userstrgdto);
	public List<UserStrgDTO> showStorageList(String userid);
}
