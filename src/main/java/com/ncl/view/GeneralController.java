package com.ncl.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

	@RequestMapping(value="index.do")
	public void index_jsp(Model model){
		model.addAttribute("liming", "测试中文123");
		System.out.println("index.jsp");
	}
	
	@RequestMapping(value="vm.vm")
	public void index_vm(Model model){
		model.addAttribute("className", "测试中文123");
		System.out.println("index.vm");
	}
}
