package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskTypeDao;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;

import java.util.List;

public class TaskTypeServiceImpl implements TaskTypeService {
    private TaskTypeDao taskTypeDao;


    public boolean addTaskType(TaskType taskType) {
        taskTypeDao.addTaskType(taskType);
        return true;
    }

    public boolean updateTaskType(TaskType taskType)
    {
        taskTypeDao.updateTaskType(taskType);
        return true;
    }

    public List<TaskType> selectTaskType(int type_id) {
        return taskTypeDao.selectTaskType(type_id);
    }

    @Override
    public TaskType selectById(int type_id) {
        return taskTypeDao.selectById(type_id);
    }


}
