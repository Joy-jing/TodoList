package cn.neu.jing.dao;

import cn.neu.jing.entity.Task;

import java.util.List;

/*
与数据库打交道
 */
public interface TaskDao {
    //添加任务
    public String addTask(Task task);
    //修改任务
    public String updateTask(Task task);
    //删除任务
    public String deleteTask(int task_id);
    //查询全部任务
    public List<Task> findAll();
    //查询今日任务
    public List<Task> todayTask();
    //添加今日任务,传入时间？？
    public String addTodayTask(Task task);
    //添加重要任务
    public String addMajorTask(Task task);
    //取消今日任务选择
    public String deleteTodayTask(int task_id);
    //取消重要选择
    public String deleteMajorTask(int task_id);

}
