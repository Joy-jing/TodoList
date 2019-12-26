package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import org.springframework.ui.Model;

import java.util.List;

public class TaskController {
    private TaskService taskService;

    public String addTask(Task task){
        taskService.addTask(task);
        return "redirect:/allTask";
    }
    //修改任务
    public String updateTask(Model model,Task task){
        taskService.updateTask(task);
        Task task1 = taskService.selectById(task.getTask_id());
        model.addAttribute("task1",task1);
        return "/allTask";
    }
    //删除任务
    public String deleteTask(int task_id){
        taskService.deleteTask(task_id);
        return "/allTask";

    }
    //查询全部任务
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
    public String addTodayTask(Task task){
        taskService.addTodayTask(task);
        return "/todayTask";
    }
    //添加重要任务
    public String addMajorTask(Task task){
        taskService.addMajorTask(task);
        return "/majorTask";
    }
    //取消今日任务选择
    public String deleteTodayTask(int task_id){
        taskService.deleteTodayTask(task_id);
        return "/allTask";

    }
    //取消重要选择
    public String deleteMajorTask(int task_id){
        taskService.deleteMajorTask(task_id);
        return "/allTask";

    }
}
