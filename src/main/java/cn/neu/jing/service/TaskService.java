package cn.neu.jing.service;

import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;

import java.util.List;

public interface TaskService {

    //添加任务
    public boolean addTask(Task task);
    //修改任务
    public boolean updateTask(Task task);
    //删除任务
    public boolean deleteTask(int task_id);
    //查询全部任务
    public List<Task> findAll();
    //查询今日任务
    public List<Task> findTodayTask();
    //添加今日任务,传入时间？？
    public boolean addTodayTask(Task task);
    //添加重要任务
    public boolean addMajorTask(Task task);
    //取消今日任务选择
    public void deleteTodayTask(int task_id);
    //取消重要选择
    public void deleteMajorTask(int task_id);
    //查询指定任务的ID
    public Task selectById(int task_id);
}
