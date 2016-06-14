package kr.or.davizn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.UserStrgDTO;
import kr.or.davizn.service.PersonalData;

@Controller
@RequestMapping("/personalData/")
public class PersonalDataController {

	@Autowired
	private PersonalData personalDataService;
	
	
	
	
	
	//데이터 리스트 보기
	@RequestMapping("showPersonalDataList.dvn")
	public String showPersonalDataList(Model model, int strgseq){
		System.out.println("Enter [showPersonDataList.dvn Controller]");
		System.out.println("Storage Number : " + strgseq);
		List<PersonalDataDTO> list = personalDataService.showPersonalDataList(strgseq);
		model.addAttribute("pdatalist", list);
		System.out.println("Result : "+list);
		return "datamanage.data-list";
	}
}
