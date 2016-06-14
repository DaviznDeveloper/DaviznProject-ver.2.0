package kr.or.davizn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.service.UserStrg;

@Controller
@RequestMapping("/userStrg/")
public class UserStorageController {

	@Autowired
	private UserStrg storageService;
	
	
	//저장소 추가하기
	@RequestMapping("addStorage.dvn")
	public void addStorage(UserStrgDTO userstrgdto){
		storageService.addStorage(userstrgdto);
	}
	
	
	//저장소 이름 수정하기
	@RequestMapping("modifyStorageName.dvn")
	public void modifyStoragename(UserStrgDTO userstrgdto){
		storageService.modifyStorageName(userstrgdto);
	}
	
	
	//저장소 리스트 보기
	@RequestMapping("showStorageList.dvn")
	public String showStorageList(Model model, String userid){
		List<UserStrgDTO> list = storageService.showStorageList(userid);
		model.addAttribute("storagelist", list);
		return "datamanage.data-repo";
	}
	
}
