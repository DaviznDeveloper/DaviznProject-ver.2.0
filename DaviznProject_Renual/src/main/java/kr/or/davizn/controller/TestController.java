package kr.or.davizn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

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
import kr.or.davizn.model.dto.PersonalDataNoteDTO;
import kr.or.davizn.service.NoteData;



@Controller
@RequestMapping("/test/")
public class TestController {
	
	@Autowired
	private NoteData notedataService;
	
	
	
	
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
	
	 	@RequestMapping("modifyNoteAction.dvn")
	 	public String modifyNoteAction(@RequestParam int dataseq,
				 					   @RequestParam int strgseq,
				 					   @RequestParam String dataname,
				 					   @RequestParam String inputArticleContents,
				 					   HttpServletRequest request
				 					   ) throws IOException{
	 		
	 		notedataService.modifyNoteFile(dataseq, request, inputArticleContents);
	 		//int result = personalDataService.updatePersonaldata(dataseq, dataname);
	 		
	 		return "redirect:detailNote.dvn?dataseq="+dataseq;
	 	}	
	 	
	@RequestMapping("imageUpload.dvn")
    public void communityImageUpload(HttpServletRequest request,FileBean dto, HttpServletResponse response, @RequestParam MultipartFile upload) {
		System.out.println("컨트롤러 탐");
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
		
	
		
	
	
	
	
	

