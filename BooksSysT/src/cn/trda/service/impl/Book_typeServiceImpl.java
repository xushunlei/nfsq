package cn.trda.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.trda.dao.Book_typeMapper;
import cn.trda.entity.Book_info;
import cn.trda.service.Book_typeService;

@Service("book_typeService")
public class Book_typeServiceImpl implements Book_typeService{
	
	@Resource
	private Book_typeMapper book_typeMapper;
	
	public Book_typeMapper getBook_typeMapper() {
		return book_typeMapper;
	}

	public void setBook_typeMapper(Book_typeMapper book_typeMapper) {
		this.book_typeMapper = book_typeMapper;
	}

	@Override
	public String[] getAllTypeName() {
		// TODO Auto-generated method stub
		return book_typeMapper.getAllTypeName();
	}


}
