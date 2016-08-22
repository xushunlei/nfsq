package cn.trda.dao;

import java.util.List;

import cn.trda.entity.Book_info;

public interface Book_infoMapper {

	int getTotalRecording(Book_info bInfo);

	List<Book_info> getBookList(Book_info bInfo);

	void updateIs_borrow(int id);

}
