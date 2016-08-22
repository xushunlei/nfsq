package cn.trda.service;

import java.util.List;

import cn.trda.entity.Book_info;

public interface Book_infoService {
	//获得总条数
	int getTotalRecording(Book_info bInfo);
	//获得booklist
	List<Book_info> getBookList(Book_info bInfo);
	void updateIs_borrow(int id);

}
