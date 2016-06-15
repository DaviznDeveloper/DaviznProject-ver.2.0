package kr.or.davizn.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.service.UserStrg;

@Controller
@RequestMapping("/userStrg/")
public class UserStorageController {

	@Autowired
	private UserStrg storageService;
	
	
	//저장소 추가하기
	@RequestMapping("addStorage.dvn")
	public String addStorage(Principal principal, String strgname){
		System.out.println("Enter [addStorage.dvn]");

		String userid = principal.getName();
		System.out.println("Enter : Userid : "+userid);
		storageService.addStorage(strgname, userid);
		return "redirect:/userStrg/showStorageList.dvn?userid="+userid;
	}
	
	
	//저장소 이름 수정하기
	@RequestMapping("modifyStorageName.dvn")
	public void modifyStoragename(UserStrgDTO userstrgdto){
		storageService.modifyStorageName(userstrgdto);
	}
	
	
	//저장소 리스트 보기
	@RequestMapping("showStorageList.dvn")
	public String showStorageList(Model model, String userid){
		System.out.println("아이디 : "+userid);
		List<UserStrgDTO> list = storageService.showStorageList(userid);
		model.addAttribute("storagelist", list);
		return "datamanage.data-repo";
	}
	

	//데이터 추가하기(노트)
	@RequestMapping("moveNoteCreate.dvn")
	public String moveNoteCreate(Model model, String strgseq){
		model.addAttribute("strgseq",strgseq);
		return "datamanage.data-note-create";
	}
	
	
	
}