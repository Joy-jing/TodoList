package cn.neu.jing.controller;

import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//控制器类
@Controller
@RequestMapping(path="/todo")
public class TaskTypeController {
    private TaskTypeService taskTypeService;
//请求映射，需要提供请求路径
    @RequestMapping(path="/allTaskType")
    public String addTaskType(TaskType taskType) {
        taskTypeService.addTaskType(taskType);
        return "allTaskType";
    }

    //修改任务类型
    @RequestMapping(path = "/allTaskType")
    public String updateTaskType(Model model, TaskType taskType) {
        taskTypeService.updateTaskType(taskType);
        TaskType type = taskTypeService.selectById(taskType.getId());
        model.addAttribute("type", type);
        return "allTaskType";
    }

    //查询类型下的任务,需要传递类型？？
    @RequestMapping(path="/taskType")
    public String selectTaskType(Model model, int type_id) {
        List<TaskType> list = taskTypeService.selectTaskType(type_id);
        model.addAttribute("list",list);
        return "taskType";
    }


}
