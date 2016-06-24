package kr.or.davizn.dataInterface;

import kr.or.davizn.dataDTO.PersonalDataSketchDTO;

public interface SketchDAO {
	
	//개인 저장소에 스케지 데이터 이름 추가
	public int addPersonalSketch(int strgseq, String dataname);
	//스케치 데이터 추가
	public int addSketch(String filename);
	//스케치 데이터의 파일 이름 가져오기
	public PersonalDataSketchDTO detailSketch(int dataseq);
	//스케치 데이터 삭제
	public int deleteSketch(int dataseq);
	//스케치 데이터 제목 수정
	public int updateDataName(String dataname, int dataseq);
	//스케치 데이터 파일 경로 가져오기
	public String getFilePath(int dataseq);
	
	
}
