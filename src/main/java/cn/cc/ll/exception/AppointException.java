package cn.cc.ll.exception;
import cn.cc.ll.enmity.Appointment;
import cn.cc.ll.enums.appointStateEnum;

//预约业务异常
public class AppointException extends RuntimeException {
    public  AppointException(String message){
        super(message);
    }
    public  AppointException(String message,Throwable cause){
        super(message, cause);
    }


}
