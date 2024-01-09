package org.toco.study.main.service;

import java.util.List;

import org.toco.study.main.vo.SampleVO;

public interface MainService {
	
	public List<SampleVO> getInfo();
	public SampleVO getOneInfo(String id);
	public int insertName(SampleVO vo);
	public int deleteOne(String id);
}
