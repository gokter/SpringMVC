package com.flyingh.app;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
	public String update(@PathVariable String username, Model model) {
		model.addAttribute(map.get(username));
		return "user/update";
	}

	@RequestMapping(value = "/{username}/update", method = RequestMethod.POST)
	public String update(@PathVariable String username, @ModelAttribute @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/update";
		}
		map.put(username, user);
		return "redirect:/user";
	}

	@RequestMapping({ "", "/", "/users", "/list" })
	public String list(Model model) {
		model.addAttribute("users", map);
		return "user/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@ModelAttribute("user") User user) {
		return "user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/add";
		}
		map.put(user.getUsername(), user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		model.addAttribute(map.get(username) != null ? map.get(username) : new User());
		return "user/show";
	}

}
