package cn.neu.jing.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private int task_id;
    private String task_name;
    private Timestamp start_time;
    private Date end_time;
    private String remark;
    private boolean task_major;
    private boolean task_finish;
    private int type_id;

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", remark='" + remark + '\'' +
                ", task_major=" + task_major +
                ", task_finish=" + task_finish +
                ", type_id=" + type_id +
                '}';
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isTask_major() {
        return task_major;
    }

    public void setTask_major(boolean task_major) {
        this.task_major = task_major;
    }

    public boolean isTask_finish() {
        return task_finish;
    }

    public void setTask_finish(boolean task_finish) {
        this.task_finish = task_finish;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
