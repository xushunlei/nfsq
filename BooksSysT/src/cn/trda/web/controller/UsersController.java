package cn.trda.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.trda.entity.Users;
import cn.trda.service.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {
	@Resource
	private UsersService usersService;
	protected ApplicationContext ctx = null;
	public UsersController() {
		// TODO Auto-generated constructor stub
//		ctx= new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
//		usersService=(UsersService) ctx.getBean("usersService");
	}
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login() {
		return "users/login";
	}

	@RequestMapping(value = "dologin", method = RequestMethod.POST)
	public String dologin(HttpServletRequest request, HttpSession session) {
		String userCode = request.getParameter("userCode");
		String userPassword = request.getParameter("userPassword");
		Users users = new Users();
		users.setUser_code(userCode);
		users.setPassword(userPassword);
		users = usersService.login(users);
		if (users != null) {
			session.setAttribute("users", users);
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			users.setLast_logintime(sdf.format(date));
			usersService.loginTime(users);
			return "redirect:/books/blist";
		} else {
			request.setAttribute("error", "用户名或密码不正确");
			return "users/login";
		}
	}
	/**
	 * 注册
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(@ModelAttribute("users") Users users){
		return "users/register";
	}
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Validated Users users, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users/register";
		}
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		users.setRegister_time(sdf.format(date));
		users.setLast_logintime(sdf.format(date));
		usersService.register(users);
		return "redirect:/users/login";
	}
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping("drop")
	public String existSystem(HttpSession session){
		session.removeAttribute("users");
		return "redirect:/users/login";
	}
	
}
