package cn.neu.jing.dao;

import cn.neu.jing.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
与数据库打交道
 */
public interface TaskDao {
    //添加任务
      boolean addTask(
              @Param("task_id") int taskId,
              @Param("task_name") String taskName,
              @Param("start_time") Date startTime,
              @Param("end_time") Date endTime,
              @Param("remark") String remark,
              @Param("task_major") boolean taskMajor,
              @Param("task_finish") boolean taskFinish,
              @Param("type_id") int typeId
              );
    //修改任务
      boolean updateTask(@Param("task_id") int taskId,
                         @Param("task_name") String taskName,
                         @Param("start_time") Date startTime,
                         @Param("end_time") Date endTime,
                         @Param("remark") String remark,
                         @Param("task_major") boolean taskMajor,
                         @Param("task_finish") boolean taskFinish,
                         @Param("type_id") int typeId);
//              @Param("task_id") int taskId,
//              @Param("start_time") Date startTime,
//              @Param("end_time") Date endTime,
//              @Param("task_major") int taskMajor,
//              @Param("task_finish") int taskFinish,
//              @Param("type_id") int typeId
//      );
    //删除任务
      boolean deleteTask(
              @Param("task_id") int taskId
              );
    //查询全部任务
      List<Task> findAll();
    //查询今日任务
      List<Task> todayTask();
    //添加今日任务,传入时间？？
      boolean addTodayTask(
              @Param("task_id") int taskId,
              @Param("task_name") String taskName,
              @Param("start_time") Date startTime,
              @Param("end_time") Date endTime,
              @Param("remark") String remark,
              @Param("task_major") int taskMajor,
              @Param("task_finish") int taskFinish,
              @Param("type_id") int typeId
      );
    //添加重要任务
      boolean addMajorTask(
              @Param("task_id") int taskId,
              @Param("task_name") String taskName,
              @Param("start_time") Date startTime,
              @Param("end_time") Date endTime,
              @Param("remark") String remark,
              @Param("task_major") int taskMajor,
              @Param("task_finish") int taskFinish,
              @Param("type_id") int typeId
      );
    //取消今日任务选择
      void deleteTodayTask(@Param("task_id") int taskId);
    //取消重要选择
      void deleteMajorTask(@Param("task_id") int taskId);
    //查询指定任务的名称
      Task selectById(@Param("task_id") int taskId);

    Task addMajorTask(@Param("task_id") int taskId,
                       @Param("task_name") String taskName);

    Task addTodayTask(@Param("task_id") int taskId,
                      @Param("task_name") String taskName);

    //分页显示所有用户信息
//    List<Task> showList(Map<String,Object> map);
    List<Task> showList(@Param("index")int index,@Param("pageSize")int pageSize);
    //计算数据总数
    int countIndex();

}
