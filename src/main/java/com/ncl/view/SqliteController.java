package com.ncl.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncl.sqlite.DB;

@Controller
public class SqliteController {

	@RequestMapping(value = "sqlite.vm")
	public void sqlite_view(Model model) {
		DB db = new DB();
		try {
			if (db.connect()) {
				db.insertV();
				List<String> nameList = db.getName("");
				System.out.println(nameList);
				model.addAttribute("nameList", nameList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		model.addAttribute("className", "测试中文123");
	}

}
