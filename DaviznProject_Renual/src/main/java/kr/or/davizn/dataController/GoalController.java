package kr.or.davizn.dataController;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.davizn.dataDTO.GoalListDTO;
import kr.or.davizn.dataDTO.NewGoal;
import kr.or.davizn.dataDTO.PersonalDataGoalDTO;
import kr.or.davizn.dataService.GoalService;

@Controller
@RequestMapping("/goal/")
public class GoalController {
   
   @Autowired

   GoalService goalService;
   
   @RequestMapping("goGoalList.dvn")
   public String goGoalList(@RequestParam int strgseq){
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
      goalService.addNewGoal(newGoal,strgseq);
      return "redirect:goGoalList.dvn?strgseq="+strgseq;
   }
   
	
	//목표 데이터 상세보기
	@RequestMapping("detailGoal.dvn")
	public String detailGoal(@RequestParam int dataseq, Model model){
		List<PersonalDataGoalDTO> gdata = goalService.detailGoal(dataseq);
		model.addAttribute("gdata", gdata);
		return "datamanage.data-goal-detail";
	}
	
	//목표 데이터 수정
		@RequestMapping("updateGoal.dvn")
		public String updateGoal(int dataseq,int strgseq, NewGoal newGoal) throws ParseException{
			//데이터 삭제
			goalService.deleteGoal(dataseq);
			goalService.addNewGoal(newGoal, strgseq);
			return "redirect:detailGoal.dvn?dataseq="+(dataseq+1);
		}
	
	
	//세부 목표 상태 비동기 변경
	@RequestMapping("updateDetailState.dvn")
	public @ResponseBody String updateDetailState(@RequestParam int detailgoalseq){
		int result = goalService.updateDetailGoalState(detailgoalseq);
		return "DB update 성공";
	}
	
	//세부 목표 달성 코멘트 변경
	@RequestMapping("updateDetailComment.dvn")
	public @ResponseBody String updateDetailComment(@RequestParam int detailgoalseq,
										  @RequestParam String commentmsg){
			
			int result = goalService.updateDetailComment(commentmsg, detailgoalseq);
			return "comment update 성공";
	}
	
	//상세화면에서 달성 퍼센트 변경
	@RequestMapping("updateGoalpercent.dvn")
	public String updateGoalpercent(@RequestParam int dataseq){
		System.out.println("dataseq :"+dataseq);
		int result = goalService.updateGoalPercent(dataseq);
		System.out.println("result : 1이면 성공 "+result);
		return "달성 퍼센트 update 완료";
	}
	
	//목표 데이터 삭제
	@RequestMapping("deleteGoal.dvn")
	public String deleteGoal(@RequestParam int dataseq,
							@RequestParam int strgseq){
		
		return "redirect:/personalData/deleteGoalData.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
	}
	

}