package cn.cc.ll.service.impl;

import cn.cc.ll.dao.AppointmentDao;
import cn.cc.ll.dao.bookDao;
import cn.cc.ll.dto.appointExecution;
import cn.cc.ll.enmity.Appointment;
import cn.cc.ll.enmity.book;
import cn.cc.ll.enums.appointStateEnum;
import cn.cc.ll.exception.AppointException;
import cn.cc.ll.exception.NoNumberException;
import cn.cc.ll.exception.RepeatAppointException;
import cn.cc.ll.service.bookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class bookServiceImpl implements bookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 注入Service依赖
    @Autowired
    private bookDao bookDao;
   @Autowired

   private AppointmentDao appointmentDao;

    @Override
    public book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
public List<book> getList() {
    return bookDao.queryAll(0, 1000);
}

    @Override
    public appointExecution appoint(long bookId, long studentId) {
        try {
            int update=bookDao.reduceNumber(bookId);

        if (update<=0){
            // 库存不足
            throw new NoNumberException("no number");
        }
        else {
            // 执行预约操作
            int insert = appointmentDao.insertAppointment(bookId, studentId);
            if (insert <= 0) {
                //重复预约
                throw new RepeatAppointException("repeat appoint");
            } else {// 预约成功
                Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                return new appointExecution(bookId, appointStateEnum.SUCCESS, appointment);
            }
        }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            // 所有编译期异常转换为运行期异常
            throw new AppointException("appoint inner error:" + e.getMessage());
        }

    }
}
