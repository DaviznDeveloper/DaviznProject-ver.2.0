package kr.or.davizn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.davizn.model.dto.FileBean;
import kr.or.davizn.model.dto.PersonalDataDTO;
import kr.or.davizn.model.dto.PersonalDataNoteDTO;
import kr.or.davizn.service.NoteData;
import kr.or.davizn.service.PersonalData;

@Controller
@RequestMapping("/personalData/")
public class PersonalDataController {

   @Autowired
   private PersonalData personalDataService;
   
   @Autowired
   private NoteData notedataService;
   
   //데이터 리스트 보기
   @RequestMapping("showPersonalDataList.dvn")
   public String showPersonalDataList(Model model, int strgseq){
      List<PersonalDataDTO> list = personalDataService.showPersonalDataList(strgseq);
      model.addAttribute("pdatalist", list);
      model.addAttribute("strgseq",strgseq);
      return "datamanage.data-list";
   }
   
   //개인 데이터 추가하기
 	@RequestMapping("addPersonalData.dvn")
 	public String addPersonalData(Model model,PersonalDataDTO pdata, 
 			@RequestParam String inputArticleContents,Principal principal,
 			HttpServletRequest request) throws IOException{
 		
 		String result = personalDataService.addPersonalData(pdata,inputArticleContents,principal,request);
 		return "redirect:addNoteData.dvn?filepath="+result;
 	}
 	
 	//개인 데이터 상세보기
 	@RequestMapping("detailPersonalData.dvn")
 	public String detailPersonalData(@RequestParam int datatype,
 									 @RequestParam int strgseq,
 									 @RequestParam int dataseq){
 		String view = null;
 		if(datatype==1){
 			//노트 데이터 상세 보기
 			view ="redirect:detailNote.dvn?dataseq="+dataseq+"&strgseq="+strgseq;
 		}else if(datatype==2){
 			//스케치 상세 보기
 			
 		}else if(datatype==3){
 			//일정 상세 보기
 		}else if(datatype==4){
 			//목표 상세보기
 		}else{
 			
 		}
 			
 		
 		return view;
 	}
 	
 	//note데이터 추가하기
 	@RequestMapping("addNoteData.dvn")
 	public String addNoteData(@RequestParam String filepath){
 		
 		int result = notedataService.addNoteData(filepath);
 
 		return "redirect:detailNoteData.dvn";
 	}
 	
 	//목록에서 note 데이터 상세조회
 	@RequestMapping("detailNote.dvn")
 	public String detailNote(@RequestParam int dataseq,
 							 Model model, HttpServletRequest request) throws IOException{
 		
 		PersonalDataNoteDTO note = notedataService.detailNote(request, dataseq);
 		model.addAttribute("note", note);
 		return "datamanage.data-note-detail";
 	}
 	
 	//상세 화면에서 데이터 삭제
 	@RequestMapping("deleteNote.dvn")
 	public String deleteNote(@RequestParam int dataseq,
 							 @RequestParam int strgseq){
 		
 		int noteResult = notedataService.deleteNote(dataseq);
 		int pdataResult = personalDataService.deleteNote(dataseq);
 		
 		return "redirect:showPersonalDataList.dvn?strgseq="+strgseq;
 	}
 	
 	//상세 화면에서 데이터 수정 창 이동(기존 정보 확인)
 	@RequestMapping("modifyNote.dvn")
 	public String modifyNote(@RequestParam int dataseq,
 							 @RequestParam int strgseq,
 							 HttpServletRequest request,
 							 Model model) 
 									 throws IOException{
 		PersonalDataNoteDTO note = notedataService.modifyNote(dataseq,request);
 		model.addAttribute("note", note);
 		return "datamanage.data-note-modi";
 	}
 	
 	@RequestMapping("modifyNoteAction.dvn")
 	public String modifyNoteAction(@RequestParam int dataseq,
			 					   @RequestParam int strgseq,
			 					   @RequestParam String dataname,
			 					   @RequestParam String inputArticleContents,
			 					   HttpServletRequest request
			 					   ) throws IOException{
 		System.out.println("파일 overwrite 확인");
 		notedataService.modifyNoteFile(dataseq, request, inputArticleContents);
 		int result = personalDataService.updatePersonaldata(dataseq, dataname);
 		
 		return "redirect:detailNote.dvn?dataseq="+dataseq;
 	}
 	
 	//note 데이터 상세 조회
 	@RequestMapping("detailNoteData.dvn")
 	public String detailNoteData(Model model, HttpServletRequest request) 
 			throws IOException{
 		PersonalDataNoteDTO note=notedataService.detailNoteData(request);
 		model.addAttribute("note", note);
 		return "datamanage.data-note-detail";
 	}
 	
 	@RequestMapping("imageUpload.dvn")
    public void communityImageUpload(HttpServletRequest request,FileBean dto, HttpServletResponse response, @RequestParam MultipartFile upload) {
		OutputStream out = null;
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
 
        try{
        	
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();
            String uploadPath =request.getRealPath("/") + "resources\\upload/" + fileName;
            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);  
            String callback = request.getParameter("CKEditorFuncNum");
 
            printWriter = response.getWriter();
            String fileUrl = "http://localhost:8090/kosta/resources/upload/" + fileName;//url경로
            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
                    + callback
                    + ",'"
                    + fileUrl  //http://localhost:8090/davizn/resources/upload/Penguins.jpg
                    + "','이미지를 업로드 하였습니다.'"
                    + ")</script>");
            printWriter.flush();
 
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        return;
    
	}
}