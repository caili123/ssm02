package cn.cc.ll.dao;

import cn.cc.ll.enmity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
//插入预约图书记录
    int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);
    //通过主键查询预约图书记录，并且携带图书实体

    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
