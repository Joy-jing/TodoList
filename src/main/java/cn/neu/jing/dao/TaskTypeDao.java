package cn.neu.jing.dao;

import cn.neu.jing.entity.TaskType;

import java.util.List;

public interface TaskTypeDao {
    //添加任务类型
    public boolean addTaskType(TaskType taskType);
    //修改任务类型
    public boolean updateTaskType(TaskType taskType);
    //查询类型下的任务,需要传递类型？？
    public List<TaskType> selectTaskType(int type_id);
    //查询指定类型的名称
    public TaskType selectById(int type_id);

}
