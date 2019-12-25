package cn.neu.jing.dao;

import cn.neu.jing.entity.TaskType;

import java.util.List;

public interface TaskTypeDao {
    //添加任务类型
    public String addTaskType(TaskType taskType);
    //修改任务类型
    public String updateTaskType(TaskType taskType);
    //查询类型下的任务,需要传递类型？？
    public List<TaskType> selectTaskType(int type_id);
}
