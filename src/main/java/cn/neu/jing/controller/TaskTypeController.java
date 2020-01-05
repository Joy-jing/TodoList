package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//控制器类
@Controller
@RequestMapping(path="/todo")
@ResponseBody
public class TaskTypeController {
    @Autowired
    private TaskTypeService taskTypeService;
//请求映射，需要提供请求路径
    @ResponseBody
    @RequestMapping(path = "/addType", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String addTaskType(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        String type = p.get("type").toString();
//        String type = t.strip();
        Map<String,String > map = new HashMap<>();
        map.put("err_code","0");
        if (type.isEmpty()) {
            map.put("err_code", "2");
            map.put("err_msg", "任务名称不能为空");
        } else {
            TaskType task = new TaskType();
            task.setTypeName(type);
            boolean b = taskTypeService.addTaskType(task);
            map.put("suc_code", "1");
            map.put("suc_msg", "添加成功");
        }
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        return s;
    }

    //修改任务类型
    @ResponseBody
    @RequestMapping(path = "/updateType", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String updateTaskType(@RequestParam Map<String, Object> p) {
        String s = p.get("content").toString();

        return "";
    }
    @ResponseBody
    @RequestMapping(path="/findType",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String selectType(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        List<TaskType> list = taskTypeService.selectType();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
    }

    //查询类型下的任务,需要传递类型？？
    @RequestMapping(path="/findTaskType")
    public String selectTaskType(Model model, int typeId) {
        List<TaskType> list = taskTypeService.selectTaskType(typeId);
        model.addAttribute("list",list);
        return "";
    }
    @RequestMapping(path="/findById")
    public String selectById(Model model){
        TaskType type = taskTypeService.selectById(1);
        model.addAttribute("",type);
        return "";
    }

    @ResponseBody
    @RequestMapping(path ="/deleteType", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String deleteType(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        System.out.println(p.get("id"));
        Map<String,String> map = new HashMap<>();
        if(p.get("id")==null){
            map.put("err_code","1");
            map.put("err_msg","删除失败");
        }else{
            map.put("err_msg","删除成功");
        }
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);

        return s;
    }
}
