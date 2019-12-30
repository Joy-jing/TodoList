package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/todo")
@ResponseBody
public class TaskController {
    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/addTask", method = {RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String addTask(@RequestParam Map<String, Object> p) {
        String title = p.get("title").toString();
        Map<String, String> response = new HashMap<>();
        response.put("err_code", "0");
        if (title.isEmpty()) {
            response.put("err_code", "1");
            response.put("err_msg", "任务名称不能为空");
        } else {
            Task task = new Task();
            task.setTask_name(title);
            System.out.println(task.getRemark());
            if (taskService.addTask(task)) {
                System.out.println("11111111111");
                response.put("err_code", "");
            } else {
                response.put("err_code", "1");
                response.put("err_msg", "添加失败，请重试");
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValueAsString(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //修改任务
    @RequestMapping(path = "/update")
    public String updateTask(Model model, Task task) {
        taskService.updateTask(task);
        Task task1 = taskService.selectById(task.getTask_id());
        model.addAttribute("task1", task1);
        return "";
    }

    //删除任务
    @RequestMapping(path = "/deleteTask")
    public String deleteTask(int task_id) {
        taskService.deleteTask(task_id);
        return "";

    }

    //查询全部任务
    @RequestMapping(path = "/findAll")
    public String findAll(Model model) {
        List<Task> list = taskService.findAll();
        model.addAttribute("list", list);
        return "";
    }

    //查询今日任务
    public String findTodayTask() {
        return "";
    }

    //添加今日任务,传入时间？？
    @RequestMapping(path = "/today")
    public String addTodayTask(Task task) {
        taskService.addTodayTask(task);
        return "";
    }

    //添加重要任务
    @RequestMapping(path = "/major")
    public String addMajorTask(Task task) {
        taskService.addMajorTask(task);
        return "";
    }

    //取消今日任务选择
    @RequestMapping(path = "/modify")
    public String deleteTodayTask(int task_id) {
        taskService.deleteTodayTask(task_id);
        return "";

    }

    //取消重要选择
    @RequestMapping(path = "/delete")

    public String deleteMajorTask(int task_id) {
        taskService.deleteMajorTask(task_id);
        return "";

    }

    @RequestMapping(path = "/find")

    public String selectById(int task_id) {
        taskService.selectById(task_id);
        return "";
    }
}
