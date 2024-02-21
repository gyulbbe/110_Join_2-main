package com.feb.jdbc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.JoinService;

@Controller
public class JoinController {

	@Autowired
	private JoinService joinService;
	
	//로그인페이지로 이동
	@GetMapping("/loginPage.do")
	public String goLoginForm() {
		return "login";
	}

	//회원가입
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		//성과 이름 합치기
		String name = params.get("name1")+" "+params.get("name2");
		params.put("name", name);
		
		//제대로 db에 값이 들어갔으면 result에 1대입
		int result = joinService.join(params);
		
		//회원가입 성공/실패 여부 alert 메시지
		if(result == 1) {
			mv.addObject("msg", "회원가입 성공");
		} else {
			mv.addObject("msg", "회원가입 실패");
		}
		mv.setViewName("login");
		return mv;
	}
}
