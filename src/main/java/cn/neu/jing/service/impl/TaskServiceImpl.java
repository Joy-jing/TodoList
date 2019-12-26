package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;
    public boolean addTask(Task task) {
        taskDao.addTask(task);
        return true;
    }

    public boolean updateTask(Task task) {
        taskDao.updateTask(task);
        return true;

    }

    public boolean deleteTask(int task_id) {
        taskDao.deleteTask(task_id);
        return true;

    }

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public List<Task> findTodayTask() {
        return taskDao.todayTask();
    }

    public boolean addTodayTask(Task task) {
        taskDao.addTodayTask(task);
        return true;

    }

    public boolean addMajorTask(Task task) {
        taskDao.addMajorTask(task);
        return true;

    }

    public void deleteTodayTask(int task_id) {
        taskDao.deleteTodayTask(task_id);
    }

    public void deleteMajorTask(int task_id) {
        taskDao.deleteMajorTask(task_id);
    }

    @Override
    public Task selectById(int task_id) {
        return taskDao.selectById(task_id);
    }
}
