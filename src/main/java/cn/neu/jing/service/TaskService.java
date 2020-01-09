package cn.neu.jing.service;

import cn.neu.jing.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskService {

    //添加任务
    boolean addTask(Task task);

    //修改任务
    boolean updateTask(Task task);

    //删除任务
    boolean deleteTask(int taskId);

    //查询全部任务
    List<Task> findAll();

    //查询今日任务
    List<Task> findTodayTask();

    //添加今日任务,传入时间？？
    boolean addTodayTask(Task task);

    //添加重要任务
    boolean addMajorTask(Task task);

    //取消今日任务选择
    void deleteTodayTask(int taskId);

    //取消重要选择
    void deleteMajorTask(int taskId);

    //查询指定任务的ID
    Task selectById(int taskId);


    //分页显示所有用户信息
    public List<Task> showlist(int index,int pageSize);
    public int countIndex();

}
