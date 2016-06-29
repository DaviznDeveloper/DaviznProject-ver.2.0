package kr.or.davizn.etcController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.davizn.etcService.Alarm;


@Component
public class AlramScheduel {
	@Autowired
	private Alarm alarm;
	//매일 매시에 알람 적용
	@Scheduled(cron="*/10 * * * * *")
	public void alram2() throws Exception{
		//System.out.println("알람 들어옴");
		/*alarm.insertAlram();
		alarm.insertscheduel();*/
	}
	
}
