package cn.neu.jing.dao;

import cn.neu.jing.entity.TaskType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskTypeDao {
    //添加任务类型
     boolean addTaskType(
//             @Param("type_id") int typeId,
             @Param("type_name") String typeName
     );
    //修改任务类型
     boolean updateTaskType(
//             @Param("type_id") int typeId,
             @Param("type_name") String typeName
     );
    //查询类型下的任务,需要传递类型？？
     List<TaskType> selectTaskType(
             @Param("type_id") int typeId
     );
    //查询指定类型的名称
     TaskType selectById(@Param("type_id") int typeId);
     boolean deleteType(@Param("type_id") int typeId);

    List<TaskType> selectType();
}
