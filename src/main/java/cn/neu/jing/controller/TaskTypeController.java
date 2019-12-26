package cn.neu.jing.controller;

import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import org.springframework.ui.Model;

import java.util.List;

public class TaskTypeController {
    private TaskTypeService taskTypeService;

    public String addTaskType(TaskType taskType) {
        taskTypeService.addTaskType(taskType);
        return "/allTaskType";
    }

    //修改任务类型
    public String updateTaskType(Model model, TaskType taskType) {
        taskTypeService.updateTaskType(taskType);
        TaskType type = taskTypeService.selectById(taskType.getId());
        model.addAttribute("type", type);
        return "/allTaskType";
    }

    //查询类型下的任务,需要传递类型？？
    public String selectTaskType(Model model, int type_id) {
        List<TaskType> list = taskTypeService.selectTaskType(type_id);
        model.addAttribute("list",list);
        return "/taskType";
    }


}
