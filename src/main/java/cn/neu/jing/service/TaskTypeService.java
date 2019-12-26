package cn.neu.jing.service;

import cn.neu.jing.entity.TaskType;

import java.util.List;

public interface TaskTypeService {
    // 添加任务类型信息
    public boolean addTaskType(TaskType taskType);

    //修改任务类型
    public boolean updateTaskType(TaskType taskType);
    //查询类型下的任务,需要传递类型？？
    public List<TaskType> selectTaskType(int type_id);

    //根据id查询类型名称
    public TaskType selectById(int type_id);
}
