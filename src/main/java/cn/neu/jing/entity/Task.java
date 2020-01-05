package cn.neu.jing.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private int taskId;
    private String taskName;
    private Timestamp startTime;
    private Date endTime;
    private String remark;
    private boolean taskMajor;
    private boolean taskFinish;

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remark='" + remark + '\'' +
                ", taskMajor=" + taskMajor +
                ", taskFinish=" + taskFinish +
                ", typeId=" + typeId +
                '}';
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isTaskMajor() {
        return taskMajor;
    }

    public void setTaskMajor(boolean taskMajor) {
        this.taskMajor = taskMajor;
    }

    public boolean isTaskFinish() {
        return taskFinish;
    }

    public void setTaskFinish(boolean taskFinish) {
        this.taskFinish = taskFinish;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    private int typeId=1;


}
