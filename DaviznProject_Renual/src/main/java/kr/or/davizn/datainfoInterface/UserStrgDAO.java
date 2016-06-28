package kr.or.davizn.datainfoInterface;

import java.util.List;

import kr.or.davizn.datainfoDTO.UserStrgDTO;

public interface UserStrgDAO {
   public int addStorage(String strgname, String userid);
   public int modifyStorageName(UserStrgDTO userstrgdto);
   public List<UserStrgDTO> showStorageList(String userid);
   //저장소 개수 구하기
   public int countUserstrg(String userid);
}
