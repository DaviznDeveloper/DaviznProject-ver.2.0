package kr.or.davizn.test;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.davizn.dataController.MessageTest;


@Controller
@RequestMapping("/message/")
public class Practice {
	
	
	MessageTest test = new MessageTest();
	
	@RequestMapping("test.dvn")
	public String printMessage(){
		test.setMessageSource(new MessageSource() {
			
			@Override
			public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
				System.out.println("첫번째");
				return null;
			}
			
			@Override
			public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
				System.out.println("두번째");
				return args[0].toString();
			}
			
			@Override
			public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
				System.out.println("세번째");
				return null;
			}
		});
		test.login("hyelim", "1004");
		return "redirect:/index.dvn";
	}
	/*System.out.println("메세지 테스트에 들어옴");
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"test/MessageTest.xml"});  
    MessageSource messageSource = (MessageSource)context;  
     
    String korMessage = messageSource.getMessage("message", new String[] {"째코"}, "no surch", Locale.KOREA);  
    String usMessage = messageSource.getMessage("message", new String[] {"jjaeko"}, "no surch", Locale.US);  
     
    System.out.println(korMessage);  
    System.out.println(usMessage);  */
	
	

}
