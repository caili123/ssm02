package cn.cc.ll.dao;

import cn.cc.ll.enmity.book;
import cn.cc.nn.baseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.List;

public class bookDaoTest extends baseTest {
    @Autowired
    private bookDao bookDao;
   @Test
  public  void testQueryById() throws Exception{
       long bookId=1000;
       book book= bookDao.queryById(bookId);
       System.out.println(book);

   }
   @Test
    public  void testQueryAll() throws Exception {
       List<book> books = bookDao.queryAll(0, 4);
       for (book book : books) {
           System.out.println(book);
       }

   }
   @Test
   public void testReduceNumber() throws Exception{
      long bookId=1000;
      int updata= bookDao.reduceNumber(bookId);
      System.out.println("updata:"+updata);
   }

}
