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
        taskTypeDao.addTaskType(taskType.getTypeName());
        return true;
    }


    public boolean updateTaskType(TaskType taskType)
    {
        taskTypeDao.updateTaskType(taskType.getTypeId(),taskType.getTypeName());
        return true;
    }
    @Override
    public List<TaskType> selectTaskType(int typeId)
    {
        return taskTypeDao.selectTaskType(typeId);
    }

    @Override
    public TaskType selectById(int typeId) {
        return taskTypeDao.selectById(typeId);
    }

    @Override
    public boolean deleteType(int typeId) {
        return taskTypeDao.deleteType(typeId);
    }

    @Override
    public List<TaskType> selectType() {
        return taskTypeDao.selectType();
    }
}
