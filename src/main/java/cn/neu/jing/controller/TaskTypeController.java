package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
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

//控制器类
@Controller
@RequestMapping(path="/todo")
@ResponseBody
public class TaskTypeController {
//    @Autowired
    private TaskTypeService taskTypeService;
//请求映射，需要提供请求路径
    @ResponseBody
    @RequestMapping(value = "/addType", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String addTaskType(@RequestParam Map<String, Object> p) {
        String type = p.get("type").toString();
        Map<String,String > map = new HashMap<>();
        map.put("err_code","0");
        if (type.isEmpty()) {
            map.put("err_code", "1");
            map.put("err_msg", "任务名称不能为空");
        } else {
            TaskType task = new TaskType();
//            int id = task.getType_id();
//            int type_id = id+1;
//            task.setType_id(type_id);
            task.setType_name(type);
            System.out.println(task);
            boolean b = taskTypeService.addTaskType(task);
            if (b) {
                System.out.println("11111111111");
                map.put("err_code", "");
            } else {
                map.put("err_code", "1");
                map.put("err_msg", "添加失败，请重试");
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //修改任务类型
    @ResponseBody
    @RequestMapping(value = "/updateType", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String updateTaskType(@RequestParam Map<String, Object> p) {
        String s = p.get("content").toString();
        
        //        taskTypeService.updateTaskType(taskType);
//        TaskType type = taskTypeService.selectById(taskType.getType_id());
//        model.addAttribute("type", type);
        return "";
    }

    //查询类型下的任务,需要传递类型？？
    @RequestMapping(path="/findType")
    public String selectTaskType(Model model, int type_id) {
        List<TaskType> list = taskTypeService.selectTaskType(type_id);
        model.addAttribute("list",list);
        return "";
    }
    @RequestMapping(path="/findById")
    public String selectById(Model model){
        TaskType type = taskTypeService.selectById(1);
        model.addAttribute("",type);
        return "";
    }

    @RequestMapping(path ="/deleteType")
    public String deleteType(int type_id) {
        taskTypeService.deleteType(type_id);
        return "";
//        return taskTypeDao.deleteType(type_id);
    }
}
