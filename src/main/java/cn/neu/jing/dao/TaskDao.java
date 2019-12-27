package cn.neu.jing.dao;

import cn.neu.jing.entity.Task;

import java.util.List;

/*
与数据库打交道
 */
public interface TaskDao {
    //添加任务
      boolean addTask(Task task);
    //修改任务
      boolean updateTask(Task task);
    //删除任务
      boolean deleteTask(int task_id);
    //查询全部任务
      List<Task> findAll();
    //查询今日任务
      List<Task> todayTask();
    //添加今日任务,传入时间？？
      boolean addTodayTask(Task task);
    //添加重要任务
      boolean addMajorTask(Task task);
    //取消今日任务选择
      void deleteTodayTask(int task_id);
    //取消重要选择
      void deleteMajorTask(int task_id);
    //查询指定任务的名称
      Task selectById(int task_id);

}
