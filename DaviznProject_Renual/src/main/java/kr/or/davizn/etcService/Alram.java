package kr.or.davizn.etcService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.or.davizn.dataDTO.PersonalDataGoalDTO;
import kr.or.davizn.dataInterface.AlramDAO;

@Service
public class Alram {
	
	@Autowired
	SqlSession sqlsession;
	
	public List<PersonalDataGoalDTO> alramList (Model model){
		
		AlramDAO alramdao= sqlsession.getMapper(AlramDAO.class);
		int total=alramdao.getCount();
		
		model.addAttribute("total",total);
		List<PersonalDataGoalDTO> list = null;
		
		return list;
	}
}
