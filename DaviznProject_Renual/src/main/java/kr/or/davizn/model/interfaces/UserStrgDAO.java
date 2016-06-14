package kr.or.davizn.model.interfaces;

import java.util.List;

import kr.or.davizn.model.dto.UserStrgDTO;

public interface UserStrgDAO {
	public int addStorage(String strgname, String userid);
	public int modifyStorageName(UserStrgDTO userstrgdto);
	public List<UserStrgDTO> showStorageList(String userid);
}
