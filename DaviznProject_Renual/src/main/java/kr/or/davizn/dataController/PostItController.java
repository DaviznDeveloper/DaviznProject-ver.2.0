package kr.or.davizn.dataController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.dataService.PostItService;

@Controller
@RequestMapping("/postit/")
public class PostItController {
	
	@Autowired
	PostItService postItService;
	
	//포스트 잇 만들기 창 이동
	@RequestMapping("movePostItCreate.dvn")
	public String movePostItCreate(int strgseq){
		return "datamanage.post-it-test";
	}
	
}
