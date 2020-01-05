package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskService;
import cn.neu.jing.util.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public String addTask(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        String title = p.get("title").toString();
        System.out.println(title);
        Map<String, String> response = new HashMap<>();
        response.put("err_code", "0");
        if (title.isEmpty()) {
            response.put("err_code", "2");
            response.put("err_msg", "任务名称不能为空");
        } else {
            Task task = new Task();
            task.setTaskName(title);
            System.out.println(task.getRemark());
            if (taskService.addTask(task)) {
                response.put("err_code", "1");
            } else {
                response.put("err_code", "2");
                response.put("err_msg", "添加失败，请重试");
            }
        }
        ObjectMapper mapper = new ObjectMapper();

        String s = mapper.writeValueAsString(response);

        return s;
    }

    //修改任务
    @RequestMapping(path = "/update")
    public String updateTask(Model model, Task task) {
        taskService.updateTask(task);
        Task task1 = taskService.selectById(task.getTaskId());
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
    @ResponseBody
    @RequestMapping(value = "/findAll", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
    public String findAll(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        List<Task> list = taskService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
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

//    //分页查询
//    @ResponseBody
//    @RequestMapping(value = "/findAll", method = {RequestMethod.GET}, produces = "application/json;charset=utf-8")
//    public String page(@RequestParam Map<String, Object> p){
//        //当前页
//        Integer pageIndex = 1;
//        //每页记录条数
//        int pageSize = 5;
//        //总记录数
//        int countIndex = taskService.countIndex();
//        //总页数（向上取整）
//        int pageCount = (int)Math.ceil((double)countIndex/pageSize);
////        if(request.getParameter("pageIndex")!=null){
////            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
////        }
//        //index代表偏移量
//        int index = (pageIndex-1)*pageSize;
//        //当前页的数据
//        List<Task> list = taskService.showList(index,pageSize);
//        Page<Task> pageUtil = new Page<Task>();
//        pageUtil.setPageIndex(pageIndex);
//        pageUtil.setPageCount(pageCount);
//        pageUtil.setPageNumber(countIndex);
//        pageUtil.setPageSize(pageSize);
//        pageUtil.setList(list);
////        model.addAttribute("pageUtil",pageUtil);
//        return "/admin_user";
//    }

}
