package org.toco.study.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.toco.study.main.vo.SampleVO;

@Mapper
public interface MainMapper {
	
	public List<SampleVO> getInfo();
	public SampleVO getOneInfo(String id);
	public int insertName(SampleVO vo);
	public int deleteOne(String id);
}
