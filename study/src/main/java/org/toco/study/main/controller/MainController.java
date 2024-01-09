package org.toco.study.main.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.toco.study.main.service.MainService;
import org.toco.study.main.vo.SampleVO;


@Controller
public class MainController {
	
	@Resource
	private MainService mainService;
	
	//샘플
	@RequestMapping(value = "index.do")
	public String sample(Model model) {
		List<SampleVO> voList = mainService.getInfo();
		model.addAttribute("sampleList", voList);
		return "index";
	}
	
	@GetMapping("loadData.do")
	@ResponseBody
	public SampleVO getOneInfo(@RequestParam("id") String id) {
		SampleVO singleVo = mainService.getOneInfo(id);
		return singleVo;
	}
	
	@PostMapping("submitForm.do")
	public String insertName(@RequestParam("name") String name, @RequestParam("age") String age) {
		SampleVO vo = new SampleVO();
		System.out.println("submitForm.do name과 age 잘 받아오는지 확인용"+name+age);
		vo.setName(name);
		vo.setAge(age);
		int result = mainService.insertName(vo);
		if(result>0) {
			return "redirect:/index.do";
		}else{
			return "FAIL";
		}
	}
	
	@PostMapping("delete.do")
	public String deleteOne(@RequestParam("id") String id) {
		int result = mainService.deleteOne(id);
		if(result>0) {
			return "redirect:/index.do";
		}else {
			return "FAIL";
		}
	}
}