package org.my.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/manager")
public class ManagerController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return "/manager/list";
	}
}
