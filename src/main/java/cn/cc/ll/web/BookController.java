package cn.cc.ll.web;

import cn.cc.ll.dto.appointExecution;
import cn.cc.ll.dto.result;
import cn.cc.ll.enmity.book;
import cn.cc.ll.enums.appointStateEnum;
import cn.cc.ll.exception.NoNumberException;
import cn.cc.ll.exception.RepeatAppointException;
import cn.cc.ll.service.bookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private bookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<book> list = bookService.getList();
        model.addAttribute("list", list);
        return "list";

    }

    @RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if (bookId == null) {
            return "redirect:/book/list";
        }
        book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";
    }
@RequestMapping(value = "/{bookId}/appoint",method = RequestMethod.POST)
@ResponseBody
private result<appointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
    if (studentId == null || studentId.equals("")) {
        return new result<appointExecution>(false,"学号不能为空");
    }
    appointExecution execution=null;
    try {
        execution = bookService.appoint(bookId, studentId);
    } catch (NoNumberException e1) {
        execution = new appointExecution(bookId, appointStateEnum.NO_NUMBER);
    } catch (RepeatAppointException e2) {
        execution = new appointExecution(bookId, appointStateEnum.REPEAT_APPOINT);
    } catch (Exception e) {
        execution = new appointExecution(bookId, appointStateEnum.INNER_ERROR);
    }
    return new result<appointExecution>(true, execution);
}
}
