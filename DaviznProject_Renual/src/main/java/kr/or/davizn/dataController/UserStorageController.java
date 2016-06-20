package kr.or.davizn.dataController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.dataDTO.PersonalDataDTO;
import kr.or.davizn.dataDTO.UserStrgDTO;
import kr.or.davizn.dataService.UserStrgService;

@Controller
@RequestMapping("/userStrg/")
public class UserStorageController {

	@Autowired
	private UserStrgService storageService;

	
	//회원 가입 시 1개의 저장소 부여
	@RequestMapping("newStorage.dvn")
	public String newStorage(String strgname, String userid){
		storageService.addStorage(strgname, userid);
		return "joinus.sign-up-ok";
	}
	
	@RequestMapping("addStorage.dvn")
	public String addStorage(Principal principal, String strgname) {
		String userid = principal.getName();
		storageService.addStorage(strgname, userid);
		return "redirect:/userStrg/showStorageList.dvn?userid=" + userid;
	}

	// 저장소 이름 수정하기
	@RequestMapping("modifyStorageName.dvn")
	public void modifyStoragename(UserStrgDTO userstrgdto) {
		storageService.modifyStorageName(userstrgdto);
	}

	// 저장소 리스트 보기
	@RequestMapping("showStorageList.dvn")
	public String showStorageList(Model model, String userid) {
		List<UserStrgDTO> list = storageService.showStorageList(userid);
		model.addAttribute("storagelist", list);
		return "datamanage.data-repo";
	}

}
