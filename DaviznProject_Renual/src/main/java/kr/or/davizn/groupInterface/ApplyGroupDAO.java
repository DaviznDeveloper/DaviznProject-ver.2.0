package kr.or.davizn.groupInterface;

import java.util.List;

import kr.or.davizn.groupDTO.ApplyGroupDTO;

public interface ApplyGroupDAO {
   
   public int addApplyMember(ApplyGroupDTO applydto);
   public int checkMember(ApplyGroupDTO applydto);
   public int deleteApply(ApplyGroupDTO applydto);
   public List<ApplyGroupDTO> getApplylist(int groupseq);
   
}