package cn.cc.ll.dao;

import cn.cc.ll.enmity.book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface bookDao {


 // 插入预约图书记录
    book queryById(long id);

  // 查询所有图书
    List<book> queryAll(@Param ("offset") int offset, @Param("limit") int limit);
    //减少馆藏数量
    int reduceNumber(long bookId);
 }
