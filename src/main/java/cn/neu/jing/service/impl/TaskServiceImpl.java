package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Override
    public boolean addTask(Task task) {
        taskDao.addTask(task.getTaskId(),
                task.getTaskName(),
                task.getStartTime(),
                task.getEndTime(),
                task.getRemark(),
                task.isTaskMajor(),
                task.isTaskFinish(),
                task.getTypeId());
        return true;
    }

    @Override
    public boolean updateTask(Task task) {

        return taskDao.updateTask(task.getTaskId(),
                task.getTaskName(),
                task.getStartTime(),
                task.getEndTime(),
                task.getRemark(),
                task.isTaskMajor(),
                task.isTaskFinish(),
                task.getTypeId());

    }
    @Override
    public boolean deleteTask(int taskId) {
        return taskDao.deleteTask(taskId);
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
        taskDao.addTodayTask(task.getTaskId(),task.getTaskName());
        return true;

    }
    @Override
    public boolean addMajorTask(Task task) {
        taskDao.addMajorTask(task.getTaskId(),task.getTaskName());
        return true;

    }
    @Override
    public void deleteTodayTask(int taskId) {
        taskDao.deleteTodayTask(taskId);
    }
    @Override
    public void deleteMajorTask(int taskId) {
        taskDao.deleteMajorTask(taskId);
    }

    @Override
    public Task selectById(int taskId) {
        return taskDao.selectById(taskId);
    }

    public List<Task> showlist(int index, int pageSize) {
        return taskDao.showList(index,pageSize);
    }


    @Override
    public int countIndex() {
        return taskDao.countIndex();
    }
}
