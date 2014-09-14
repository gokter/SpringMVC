package com.flyingh.app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.webxml.MobileCodeWSSoap;

@Controller
@RequestMapping("/mobile")
public class MobileCodeController {
	private MobileCodeWSSoap mobileCodeWSSoap;

	@Resource
	public void setMobileCodeWSSoap(MobileCodeWSSoap mobileCodeWSSoap) {
		this.mobileCodeWSSoap = mobileCodeWSSoap;
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String queryLocation() {
		return "mobile/query";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String queryLocation(String mobileCode, Model model) {
		model.addAttribute("result", mobileCodeWSSoap.getMobileCodeInfo(mobileCode, ""));
		return "mobile/query";
	}

}
