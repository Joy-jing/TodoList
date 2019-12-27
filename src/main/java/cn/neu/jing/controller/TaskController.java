package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping(path = "/todo")
@ResponseBody
public class TaskController {
    private TaskService taskService;
    @RequestMapping(path = "/allTask")
    public String addTask(Task task){
        taskService.addTask(task);
        return "allTask";
    }
    //修改任务
    @RequestMapping(path="/allTask")
    public String updateTask(Model model,Task task){
        taskService.updateTask(task);
        Task task1 = taskService.selectById(task.getTask_id());
        model.addAttribute("task1",task1);
        return "allTask";
    }
    //删除任务
    @RequestMapping(path="/allTask")
    public String deleteTask(int task_id){
        taskService.deleteTask(task_id);
        return "allTask";

    }
    //查询全部任务
    @RequestMapping(path="/allTask")
    public String findAll(Model model){
        List<Task> list = taskService.findAll();
        model.addAttribute("list",list);
        return "allTask";
    }
    //查询今日任务
    public String findTodayTask(){
        return "";
    }
    //添加今日任务,传入时间？？
    @RequestMapping(path="/todayTask")
    public String addTodayTask(Task task){
        taskService.addTodayTask(task);
        return "todayTask";
    }
    //添加重要任务
    @RequestMapping(path="/majorTask")
    public String addMajorTask(Task task){
        taskService.addMajorTask(task);
        return "majorTask";
    }
    //取消今日任务选择
    @RequestMapping(path="/allTask")
    public String deleteTodayTask(int task_id){
        taskService.deleteTodayTask(task_id);
        return "allTask";

    }
    //取消重要选择
    @RequestMapping(path="/allTask")

    public String deleteMajorTask(int task_id){
        taskService.deleteMajorTask(task_id);
        return "allTask";

    }
}
