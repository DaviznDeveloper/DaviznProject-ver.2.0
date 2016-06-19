package kr.or.davizn.dataController;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



public class MessageTest implements MessageSourceAware{  
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void login(String username, String password) {
    	Locale locale = Locale.getDefault();
        Object[] args = new String[]{username};
        String failMessage = messageSource.getMessage("로그인페일", args, locale);
        System.out.println(failMessage);
    }
}
