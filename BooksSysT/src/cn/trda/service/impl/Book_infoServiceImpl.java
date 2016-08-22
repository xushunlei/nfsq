package cn.trda.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.trda.dao.Book_infoMapper;
import cn.trda.entity.Book_info;
import cn.trda.service.Book_infoService;
@Service("book_infoService")
public class Book_infoServiceImpl implements Book_infoService {
	@Resource
	private Book_infoMapper book_infoMapper;

	public Book_infoMapper getBook_infoMapper() {
		return book_infoMapper;
	}

	public void setBook_infoMapper(Book_infoMapper book_infoMapper) {
		this.book_infoMapper = book_infoMapper;
	}

	@Override
	public int getTotalRecording(Book_info bInfo) {
		// TODO Auto-generated method stub
		return book_infoMapper.getTotalRecording(bInfo);
	}

	@Override
	public List<Book_info> getBookList(Book_info bInfo) {
		// TODO Auto-generated method stub
		return book_infoMapper.getBookList(bInfo);
	}

	@Override
	public void updateIs_borrow(int id) {
		// TODO Auto-generated method stub
		book_infoMapper.updateIs_borrow(id);
	}
	
	
	
	
}
