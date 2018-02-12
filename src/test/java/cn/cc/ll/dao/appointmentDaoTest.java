package cn.cc.ll.dao;

import cn.cc.ll.enmity.Appointment;
import cn.cc.nn.baseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class appointmentDaoTest extends baseTest {
@Autowired
private  AppointmentDao appointmentDao;
 @Test
 public void testInsertAppointment() throws Exception {
   long bookId =1000;
   long studentId=12345678910l;
   int insert =appointmentDao.insertAppointment(bookId,studentId);
   System.out.println("insert=" + insert);
 }
 @Test
 public void testQueryByKeyWithBook() throws Exception {
     long bookId =1000;
     long studentId=12345678910l;
     Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
     System.out.println(appointment);
     System.out.println(appointment.getBook());


 }
}
