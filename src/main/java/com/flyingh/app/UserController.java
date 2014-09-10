package com.flyingh.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flyingh.app.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private final Map<String, User> map = new HashMap<String, User>();

	public UserController() {
		map.put("a", new User("a", "a", "a", "a@a.com"));
		map.put("b", new User("b", "b", "b", "b@b.com"));
		map.put("c", new User("c", "c", "c", "c@c.com"));
		map.put("d", new User("d", "d", "d", "d@d.com"));
		map.put("e", new User("e", "e", "e", "e@e.com"));
	}

	@RequestMapping({ "", "/", "/users", "/list" })
	public String list(Model model) {
		model.addAttribute("users", map);
		return "user/list";
	}
}
