package kr.or.davizn.etcController;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
   
   
   @RequestMapping("index.dvn")
   public String moveIndex(Principal principal){
      if(principal ==null){return "home.index";}
      return "redirect:index2.dvn"; 
   }
   
   @RequestMapping("index2.dvn")
   public String moveIndex2(Principal principal, HttpSession session) throws Exception{
      String userid = principal.getName();
      session.setAttribute("userid", userid);
      
      return "home.index"; //select 시키면 됨
   }
   
}