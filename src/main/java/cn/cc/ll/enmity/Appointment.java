package cn.cc.ll.enmity;

import java.util.Date;

public class Appointment {
    private  long bookId;
    private  long studentId;
   private Date appointTime;

   private  book book;

    public Appointment() {
    }

    public Appointment(long bookId, long studentId, Date appointTime, book book) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
        this.book = book;
    }

    public Appointment(long bookId, long studentId, Date appointTime) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                '}';
    }

    public long getBookId() {

        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public cn.cc.ll.enmity.book getBook() {
        return book;
    }

    public void setBook(book book) {
        this.book = book;
    }
}
