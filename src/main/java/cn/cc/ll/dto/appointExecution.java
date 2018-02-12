package cn.cc.ll.dto;

import cn.cc.ll.enmity.Appointment;
import cn.cc.ll.enums.appointStateEnum;

public class appointExecution {
    private long bookId;
    private  int state;
    private String stateInfo;

    // 预约成功对象
    private Appointment appointment;
    // 预约失败的构造器
    public appointExecution(long bookId, appointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = state;
        this.stateInfo = stateInfo;
    }
    // 预约成功的构造器
    public appointExecution(long bookId, appointStateEnum stateEnum, Appointment appointment) {
        this.bookId = bookId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "appointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
