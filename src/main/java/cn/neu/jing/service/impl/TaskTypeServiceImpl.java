package cn.neu.jing.service.impl;

import cn.neu.jing.dao.TaskTypeDao;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {
    @Autowired
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
    @Override
    public List<TaskType> selectTaskType(int type_id)
    {
        return taskTypeDao.selectTaskType(type_id);
    }

    @Override
    public TaskType selectById(int type_id) {
        System.out.println("111");
        return taskTypeDao.selectById(type_id);
    }
}
