package kr.or.davizn.datasetController;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.datainfoDTO.PersonalDataDTO;
import kr.or.davizn.datainfoService.CommonDataService;
import kr.or.davizn.datainfoService.PersonalService;
import kr.or.davizn.datasetDTO.NewGoalDTO;
import kr.or.davizn.datasetDTO.PersonalDataGoalDTO;
import kr.or.davizn.datasetService.GoalService;

@Controller
@RequestMapping("/goal/")
public class GoalController {
	@Autowired
	GoalService goalService;
	@Autowired
	PersonalService personalService;
	@Autowired
	CommonDataService commonService;
	
	
	
	@RequestMapping("showGoalList.dvn")
	public String showGoalList(Model model, @RequestParam int strgseq) {
		List<PersonalDataGoalDTO> goalList = goalService.showGoalList(strgseq);
		model.addAttribute("goalList", goalList);
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-goal-list";
	}

	@RequestMapping("addGoal.dvn")
	@Transactional
	public String addGoal(NewGoalDTO newGoal, PersonalDataDTO personaldto) throws ParseException {
		personalService.addPersonalData(personaldto);
		int dataseq = personalService.getDataseq(personaldto.getStrgseq());
		commonService.addDataseq(dataseq);
		goalService.addNewGoal(newGoal);
		return "redirect:detailGoal.dvn?dataseq=" + dataseq;
	}

	// 목표 데이터 상세보기
	@RequestMapping("detailGoal.dvn")
	public String detailGoal(@RequestParam int dataseq, Model model) {
		List<PersonalDataGoalDTO> gdata = goalService.detailGoal(dataseq);
		model.addAttribute("gdata", gdata);
		return "datamanage.data-goal-detail";
	}

	// 목표 데이터 수정
	@RequestMapping("updateGoal.dvn")
	@Transactional
	public String updateGoal(PersonalDataDTO personaldto, NewGoalDTO newGoal) throws ParseException {
		
		int newdataseq = personaldto.getDataseq() + 1;
		personalService.deletePersonalData(personaldto.getDataseq());
		commonService.deleteDataseq(personaldto.getDataseq());
		personaldto.setDataseq(newdataseq);
		personalService.addPersonalData(personaldto);
		commonService.addDataseq(newdataseq);
		goalService.addNewGoal(newGoal);
		
		return "redirect:detailGoal.dvn?dataseq="+newdataseq;
	}

	// 세부 목표 상태 비동기 변경
	@RequestMapping("updateDetailState.dvn")
	public @ResponseBody String updateDetailState(@RequestParam int detailgoalseq) {
		int result = goalService.updateDetailGoalState(detailgoalseq);
		return "DB update 성공";
	}

	// 세부 목표 달성 코멘트 변경
	@RequestMapping("updateDetailComment.dvn")
	public @ResponseBody String updateDetailComment(@RequestParam int detailgoalseq, @RequestParam String commentmsg) {
		int result = goalService.updateDetailComment(commentmsg, detailgoalseq);
		return "comment update 성공";
	}

	// 상세화면에서 달성 퍼센트 변경
	@RequestMapping("updateGoalpercent.dvn")
	public @ResponseBody String updateGoalpercent(@RequestParam int dataseq) {
		int result = goalService.updateGoalPercent(dataseq);
		return "달성 퍼센트 update 완료";
	}


}