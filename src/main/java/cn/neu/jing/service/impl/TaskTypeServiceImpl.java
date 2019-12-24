package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskTypeDao;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;

import java.util.List;

public class TaskTypeServiceImpl implements TaskTypeService {
    private TaskTypeDao taskTypeDao;


    public void addTaskType(TaskType taskType) {
        taskTypeDao.addTaskType(taskType);
    }

    public void updateTaskType(TaskType taskType) {
        taskTypeDao.updateTaskType(taskType);
    }

    public List<TaskType> selectTaskType(int type_id) {
        return taskTypeDao.selectTaskType(type_id);
    }
}
