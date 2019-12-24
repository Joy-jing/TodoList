package cn.neu.jing.entity;

public class TaskType {
    private int id;
    private String task_name;

    @Override
    public String toString() {
        return "TaskType{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
}
