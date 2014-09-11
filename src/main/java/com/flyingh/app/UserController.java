package com.flyingh.app;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.flyingh.app.vo.User;
import com.flyingh.exception.UserException;

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

	// @ExceptionHandler(UserException.class)
	// public String handleException(UserException exception, HttpServletRequest request) {
	// request.setAttribute("error", exception.getMessage());
	// return "error";
	// }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute User user) {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, HttpSession session) {
		final User user = map.get(username);
		if (user == null) {
			throw new UserException("user not found");
		}
		if (!Objects.equals(password, user.getPassword())) {
			throw new UserException("password is wrong");
		}
		session.setAttribute("loginUser", user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/{username}/delete")
	public String delete(@PathVariable String username) {
		map.remove(username);
		return "redirect:/user/list";
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
	public String add(@Valid User user, BindingResult result, MultipartFile file, HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			return "user/add";
		}
		System.out.println(file.getName() + "-->" + file.getOriginalFilename() + "--->" + file.getContentType());
		final String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(realPath);
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, file.getOriginalFilename()));
		map.put(user.getUsername(), user);
		return "redirect:/user/list";
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String show(@PathVariable String username, Model model) {
		model.addAttribute(map.get(username) != null ? map.get(username) : new User());
		return "user/show";
	}

}
