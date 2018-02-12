package cn.cc.ll.servive.impl;

import cn.cc.ll.dto.appointExecution;
import cn.cc.ll.exception.AppointException;
import cn.cc.ll.service.bookService;
import cn.cc.nn.baseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends baseTest {
    @Autowired
    private bookService bookService;
    @Test
    public  void testAppoint() throws Exception{
        long bookId = 1001;
        long studentId = 12345678910L;
        appointExecution execution=bookService.appoint(bookId,studentId);
        System.out.println(execution);
    }
}
