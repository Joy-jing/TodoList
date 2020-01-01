package cn.neu.jing.service;

import cn.neu.jing.entity.TaskType;

import java.util.List;

public interface TaskTypeService {
    // 添加任务类型信息
     boolean addTaskType(TaskType taskType);

    //修改任务类型
     boolean updateTaskType(TaskType taskType);
    //查询类型下的任务,需要传递类型？？
     List<TaskType> selectTaskType(int type_id);

    //根据id查询类型名称
     TaskType selectById(int type_id);
    boolean deleteType(int type_id);

    List<TaskType> selectType();
}
