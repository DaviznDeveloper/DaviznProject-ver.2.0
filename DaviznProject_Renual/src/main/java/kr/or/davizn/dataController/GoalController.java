package kr.or.davizn.dataController;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.dataDTO.GoalListDTO;
import kr.or.davizn.dataDTO.NewGoal;
import kr.or.davizn.dataService.GoalService;

@Controller
@RequestMapping("/goal/")
public class GoalController {
	
	@Autowired
	GoalService goalService;
	
	@RequestMapping("goGoalList.dvn")
	public String goGoalList(@RequestParam int strgseq){
		//List<GoalListDTO> goalList = goalService.showGoalList(strgseq);
		//model.addAttribute(goalList);
		return "redirect:showGoalList.dvn?strgseq=" + strgseq;
	}
	
	@RequestMapping("showGoalList.dvn")
	public String showGoalList(Model model,@RequestParam int strgseq){
		List<GoalListDTO> goalList = goalService.showGoalList(strgseq);
	
		model.addAttribute("goalList",goalList);
		model.addAttribute("strgseq",strgseq);
		return "datamanage.data-goal-list";
	}
	
	@RequestMapping("addGoal.dvn")
	public String addGoal(NewGoal newGoal, @RequestParam int strgseq) throws ParseException{
		System.out.println("addGoal.dvn에 들어옴");
		System.out.println(newGoal.getDetailnames().length);
		System.out.println(newGoal.getStartdate());
		System.out.println(newGoal.getFinaldate());
		
		goalService.addNewGoal(newGoal,strgseq);
		//추가 함수 
		return "redirect:goGoalList.dvn?strgseq="+strgseq;
	}
	

}
