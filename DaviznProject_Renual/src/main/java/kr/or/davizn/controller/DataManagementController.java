package kr.or.davizn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.model.dto.MemberStorageDTO;
import kr.or.davizn.service.MemberStorage;

@Controller
@RequestMapping("/datamanage/")
public class DataManagementController {

	@Autowired
	private MemberStorage storageService;
	
	
	//저장소 추가하기
	@RequestMapping("addStorage.dvn")
	public void addStorage(MemberStorageDTO MSdto){
		storageService.addStorage(MSdto);
	}
	
	
	//저장소 이름 수정하기
	@RequestMapping("modifyStorageName.dvn")
	public void modifyStoragename(MemberStorageDTO MSdto){
		storageService.modifyStorageName(MSdto);
	}
	
	
	//저장소 리스트 보기
	@RequestMapping("showStorageList.dvn")
	public String showStorageList(Model model, String userid){
		List<MemberStorageDTO> list = storageService.showStorageList(userid);
		model.addAttribute("list", list);
		return "datamanage/data-repo";
	}
	
	
	//데이터 row 저장하기
	@RequestMapping("storeRows.dvn")
	public void storeRows(){
		
	}
	
	//데이터 col 저장하기
	@RequestMapping("storeCols.dvn")
	public void storeCols(){
		
	}
	
	//데이터 values 저장하기
	@RequestMapping("storeValues.dvn")
	public void storeValues(){
		
	}
	
}
