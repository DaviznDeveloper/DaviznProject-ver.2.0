package kr.or.davizn.groupInterface;

import java.util.List;

import kr.or.davizn.groupDTO.VersionDTO;

public interface ManageVersionDAO {
	public int addverison(VersionDTO versiondto);
	public List<VersionDTO> getVersionlist(int dataseq);
}
