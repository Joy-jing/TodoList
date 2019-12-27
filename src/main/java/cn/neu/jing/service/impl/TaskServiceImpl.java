package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public boolean addTask(Task task) {
        taskDao.addTask(task);
        return true;
    }
    @Override
    public boolean updateTask(Task task) {
        taskDao.updateTask(task);
        return true;

    }
    @Override
    public boolean deleteTask(int task_id) {
        taskDao.deleteTask(task_id);
        return true;
    }
    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }
    @Override
    public List<Task> findTodayTask() {
        return taskDao.todayTask();
    }
    @Override
    public boolean addTodayTask(Task task) {
        taskDao.addTodayTask(task);
        return true;

    }
    @Override
    public boolean addMajorTask(Task task) {
        taskDao.addMajorTask(task);
        return true;

    }
    @Override
    public void deleteTodayTask(int task_id) {
        taskDao.deleteTodayTask(task_id);
    }
    @Override
    public void deleteMajorTask(int task_id) {
        taskDao.deleteMajorTask(task_id);
    }

    @Override
    public Task selectById(int task_id) {
        return taskDao.selectById(task_id);
    }
}
