package kr.or.davizn.controller;

import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/note/")
public class NoteController{
	
	@RequestMapping("save.dvn")
	public @ResponseBody String test(@RequestBody String sendNoteData){
		System.out.println("Enter [ee.dvn controller]");
		System.out.println(sendNoteData);
		
		String result = URLDecoder.decode(sendNoteData);
		System.out.println(result);
		return "결과 값";
	}
	
}
