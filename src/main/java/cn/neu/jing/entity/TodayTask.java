package cn.neu.jing.entity;

import java.util.Date;

public class TodayTask {
    private int id;
    private int task_id;
    private Date time;

    @Override
    public String toString() {
        return "TodayTask{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
