package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;
    public void addTask(Task task) {
        taskDao.addTask(task);
    }

    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }

    public void deleteTask(int task_id) {
        taskDao.deleteTask(task_id);
    }

    public List<Task> findAll() {
        return taskDao.findAll();
    }

    public List<Task> findTodayTask() {
        return taskDao.todayTask();
    }

    public void addTodayTask(Task task) {
        taskDao.addTodayTask(task);
    }

    public void addMajorTask(Task task) {
        taskDao.addMajorTask(task);
    }

    public void deleteTodayTask(int task_id) {
        taskDao.deleteTodayTask(task_id);
    }

    public void deleteMajorTask(int task_id) {
        taskDao.deleteMajorTask(task_id);
    }
}
