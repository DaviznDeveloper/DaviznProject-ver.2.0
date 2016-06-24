package kr.or.davizn.dataController;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.dataDTO.PersonalDataSketchDTO;
import kr.or.davizn.dataService.SketchService;

@Controller
@RequestMapping("/sketch/")
public class SketchController {
	
	@Autowired
	SketchService sketchservice;
	
	// 스케치 창 이동
	@RequestMapping("moveSketchCreate.dvn")
	public String moveNoteCreate(Model model, int strgseq) {
		model.addAttribute("strgseq", strgseq);
		return "datamanage.data-sketch-create";
	}
	
	//스케치 데이터 파일 만들기
	@RequestMapping("writeSketchData.dvn")
	public String writeSketchData(int strgseq,String dataname, String sketchData
								,Principal principal, HttpServletRequest request) 
										throws IOException{
		
		//개인 저장소에 스케치 데이터 추가/파일  write
		String filepath = sketchservice.writeSketchData
				(strgseq,dataname,principal,request,sketchData);
		
		return "redirect:addSketchData.dvn?filepath="+filepath+"&strgseq="+strgseq;
	}
	//스케치 데이터 추가
	@RequestMapping("addSketchData.dvn")
	public String addSketchData(String filepath, String strgseq){
		int result = sketchservice.addSketchData(filepath);
		
		return "redirect:/personalData/showPersonalDataList.dvn?strgseq="+strgseq;
	}
	
	//스케치 데이터 상세보기
	@RequestMapping("detailsketch.dvn")
	public String detailsketch(int dataseq, int strgseq, 
			HttpServletRequest request,Model model) 
			throws IOException{
		//dataseq를 가지고 파일 이름을 가져온다
		PersonalDataSketchDTO sketch = sketchservice.detailSketch(dataseq, request);
		//가져온 파일 이름을 가지고 파일의 내용을 가져온다
		model.addAttribute("sketch", sketch);
		return "datamanage.data-sketch-detail";
	}
	
	//스케치 데이터 삭제
	@RequestMapping("deleteSketch.dvn")
	public String deleteSketch(int dataseq, int strgseq){
		int result = sketchservice.deleteSketch(dataseq);
		return "redirect:/personalData/showPersonalDataList.dvn?strgseq="+strgseq;
	}
	
	//스케치 데이터 수정하기(기존 정보 확인)
	@RequestMapping("ModifySketchView.dvn")
	public String modifySketch(int dataseq, int strgseq,
			HttpServletRequest request,Model model) 
			throws IOException{
		//파일 이름의 이름을 가져오기
		PersonalDataSketchDTO sketch = sketchservice.detailSketch(dataseq, request);
		model.addAttribute("sketch", sketch);
		return "datamanage.data-sketch-modi";
	}
	
	@RequestMapping("ModifySketchAction.dvn")
	public String ModifySketchAction(String dataname,String sketchData,
									int dataseq, int strgseq, 
									HttpServletRequest request) throws IOException{
		
		sketchservice.updateSketchAction(dataname, dataseq, sketchData, request);
		return "redirect:detailsketch.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
	}
	
	
	
}
