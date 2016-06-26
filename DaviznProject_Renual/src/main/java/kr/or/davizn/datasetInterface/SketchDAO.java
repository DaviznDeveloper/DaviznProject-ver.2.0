package kr.or.davizn.datasetInterface;

import kr.or.davizn.datasetDTO.PersonalDataSketchDTO;

public interface SketchDAO {
	

	//스케치 데이터 추가
	public int addSketch(String filename);
	//스케치 데이터 가져오기
	public PersonalDataSketchDTO detailSketch(int dataseq);
}
