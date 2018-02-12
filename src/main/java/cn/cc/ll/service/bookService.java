package cn.cc.ll.service;

import cn.cc.ll.dto.appointExecution;
import cn.cc.ll.enmity.book;

import java.util.List;

public interface bookService {
//查询一本图书
    book getById(long bookId);
 //查询所有图书
 List<book> getList();
 //预约图书
    appointExecution appoint(long bookId, long studentId);
}
