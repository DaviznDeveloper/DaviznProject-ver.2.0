package kr.or.davizn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.davizn.model.dto.FileBean;



@Controller
@RequestMapping("/test/")
public class TestController {
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
		
	
		
	
	
	
	
	

