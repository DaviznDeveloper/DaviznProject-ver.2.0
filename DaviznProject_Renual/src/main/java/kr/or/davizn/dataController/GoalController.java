package kr.or.davizn.dataController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.dataDTO.PersonalDataGoalDTO;
import kr.or.davizn.dataService.GoalService;

@Controller
@RequestMapping("/goal/")
public class GoalController {
	
	@Autowired
	GoalService goalservice;
	
	//목표 데이터 상세보기
	@RequestMapping("detailGoal.dvn")
	public String detailGoal(@RequestParam int dataseq, Model model){
		List<PersonalDataGoalDTO> gdata = goalservice.detailGoal(dataseq);
		model.addAttribute("gdata", gdata);
		return "datamanage.data-goal-detail";
	}
	
	//세부 목표 상태 비동기 변경
	@RequestMapping("updateDetailState.dvn")
	public @ResponseBody String updateDetailState(@RequestParam int detailgoalseq){
		
		int result = goalservice.updateDetailGoalState(detailgoalseq);
		return "DB update 성공";
	}
	
	//목표 데이터 삭제
	@RequestMapping("deleteGoal.dvn")
	public String deleteGoal(@RequestParam int dataseq,
							@RequestParam int strgseq){
		return "redirect:/personalData/deleteGoalData.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
	}
	
	@RequestMapping("updateDetailComment.dvn")
	public @ResponseBody String updateDetailComment(@RequestParam int detailgoalseq,
									  @RequestParam String commentmsg){
		
		int result = goalservice.updateDetailComment(commentmsg, detailgoalseq);
		
		return "comment update 성공";
	}
	
	
}
