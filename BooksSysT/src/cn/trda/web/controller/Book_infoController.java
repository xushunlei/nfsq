package cn.trda.web.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;
import cn.trda.entity.Book_info;
import cn.trda.service.Book_infoService;
import cn.trda.service.Book_typeService;

@Controller
@RequestMapping("books")
public class Book_infoController {
	//@Resource
	private Logger loger = Logger.getLogger(Book_infoController.class);
	private Book_infoService book_infoService=null;
	private Book_typeService book_typeService=null;
	protected ApplicationContext ctx = null;
	private int pageSize = 3;
	
	public Book_infoController() {
		// TODO Auto-generated constructor stub
		ctx= new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		book_infoService=(Book_infoService) ctx.getBean("book_infoService");
		book_typeService=(Book_typeService) ctx.getBean("book_typeService");
	}
	@RequestMapping(value="blist",method=RequestMethod.GET)
	public String bookList(HttpServletRequest request, Model model){
		String book_name=request.getParameter("book_name");
		String type_name=request.getParameter("type_name");
		String is_borrow=request.getParameter("is_borrow");
		String currentPage = request.getParameter("currentPage");
	/*System.out.println("book_name:"+book_name);
	System.out.println("type_name:"+type_name);
	System.out.println("isborrow1:"+is_borrow);*/
		if (currentPage == null) {
			currentPage = "1";
		}
		if (type_name!=null) {
			if (type_name.equals("0")) {
				type_name=null;
			}
		}
		List<Book_info> bList=null;
		String []book_typeName=null;
		Book_info bInfo=new Book_info();
		bInfo.setBook_name(book_name);
		bInfo.setType_name(type_name);
		if (is_borrow==null||is_borrow.equals("请选择")) {
			is_borrow="2";
		}
	//System.out.println("isborrow2:"+is_borrow);
		bInfo.setIs_borrow(Integer.parseInt(is_borrow));
		int start = (Integer.parseInt(currentPage) - 1) * pageSize;
		bInfo.setStartNum(start);
		//获得type数组
		book_typeName=book_typeService.getAllTypeName();
		int totalPage = 0;
		//获得总条数
		int totalRecording =book_infoService.getTotalRecording(bInfo);
	//System.out.println("totalRecording:"+totalRecording);
		if (totalRecording % pageSize == 0) {
			totalPage = totalRecording / pageSize;
		} else {
			totalPage = (totalRecording / pageSize) + 1;
		}
	//获得booklist
		bList=book_infoService.getBookList(bInfo);
	//System.out.println("blist:"+bList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("book_typeName", book_typeName);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("bList", bList);
		return "books/main";
	}
	@RequestMapping(value="/{book_id}/update")
	public String updateIs_borrow(@PathVariable("book_id") int id, Model model){
		book_infoService.updateIs_borrow(id);
		return "redirect:/books/blist";
	}

	
}
