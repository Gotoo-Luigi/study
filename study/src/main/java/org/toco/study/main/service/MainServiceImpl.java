package org.toco.study.main.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.toco.study.main.mapper.MainMapper;
import org.toco.study.main.vo.SampleVO;

@Service
public class MainServiceImpl implements MainService {
	
	@Resource
	private MainMapper mainMapper;

	@Override
	public List<SampleVO> getInfo() {
		List<SampleVO> voList = mainMapper.getInfo();
		return voList;
	}
	
	public SampleVO getOneInfo(String id) {
		SampleVO voOne = mainMapper.getOneInfo(id);
		return voOne;
	}
	
	public int insertName(SampleVO vo) {
		System.out.println("MainServiceImpl insertName 메서드 데이터 확인용"+vo.getName() + vo.getAge());
		int result = mainMapper.insertName(vo);
		return result;
	}
	
	public int deleteOne(String id) {
		int result = mainMapper.deleteOne(id);
		return result;
	}
	
}

