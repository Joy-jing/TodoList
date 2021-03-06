package cn.neu.jing.controller;

import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import cn.neu.jing.util.Page;
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
    @RequestMapping(path = "/updateType/{id}", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String updateTaskType(@RequestParam Map<String, Object> p,@PathVariable("id")String id) throws JsonProcessingException {
        String taskName = p.get("typeName").toString();
        int i = Integer.parseInt(id);
        Map<String, String> response = new HashMap<>();
        response.put("err_code", "0");
        if(taskName.isEmpty()){
            response.put("err_code", "2");
            response.put("err_msg", "任务类型名称不能为空");
        }else {
            TaskType type = new TaskType();
            type.setTypeName(taskName);
            type.setTypeId(i);
            if (taskTypeService.updateTaskType(type)) {
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
    @ResponseBody
    @RequestMapping(path="/findType",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String selectType(@RequestParam Map<String, Object> p) throws JsonProcessingException {
        List<TaskType> list = taskTypeService.selectType();
        System.out.println(list);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
    }

    //查询类型下的任务,需要传递类型
    @ResponseBody
    @RequestMapping(path="/findTaskType/{id}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String selectTaskType(@RequestParam Map<String, Object> p,@PathVariable("id")String id) throws JsonProcessingException {
        int typeId = Integer.parseInt(id);
        List<TaskType> list = taskTypeService.selectTaskType(typeId);
        System.out.println(list);
        //当前页
        Integer pageIndex = 1;
        //每页记录条数
        int pageSize = 4;
        //总记录数
        int countIndex = list.size();
        //总页数（向上取整）
        int pageCount = (int)Math.ceil((double)countIndex/pageSize);
//        if(request.getParameter("pageIndex")!=null){
//            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//        }
        //index代表偏移量
        int index = (pageIndex-1)*pageSize;
        //当前页的数据
        List<TaskType> curList = taskTypeService.showList(typeId,index,pageSize);
        System.out.println(curList);
        Page<TaskType> pageUtil = new Page<TaskType>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageCount(pageCount);
        pageUtil.setPageNumber(countIndex);
        pageUtil.setPageSize(pageSize);
        pageUtil.setList(curList);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(pageUtil);
        return s;
    }
    @RequestMapping(path="/findById")
    public String selectById(Model model){
        TaskType type = taskTypeService.selectById(1);
        model.addAttribute("",type);
        return "";
    }

    @ResponseBody
    @RequestMapping(path ="/deleteType/{id}", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String deleteType(@PathVariable("id")String id) throws JsonProcessingException {
        Map<String,String> info = new HashMap<>();
        int id1 = Integer.parseInt(id);
        if(taskTypeService.deleteType(id1)){
            info.put("err_code","1");
            info.put("err_msg","删除成功");
        }else{
            info.put("err_code","2");
            info.put("err_msg","删除失败");
        }
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(info);
        return s;
    }
}
