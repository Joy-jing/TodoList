import cn.neu.jing.dao.TaskTypeDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ItemsTest {
//    //service测试
//    @Test
//    public void selectById(){
//        //获取spring容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
////        从容器中拿到所需的dao的代理对象
//        TaskTypeDao bean = ac.getBean(TaskTypeDao.class);
//        TaskType type = bean.selectById(2);
//        System.out.println(type.getType_name());
//    }


    //service测试
    @Test
    public void selectById(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        从容器中拿到所需的dao的代理对象
        TaskTypeService bean = ac.getBean(TaskTypeService.class);
        TaskType type = bean.selectById(2);
        System.out.println(type.getTypeName());
    }

    @Test
    public void addTaskType(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaskTypeService bean = ac.getBean(TaskTypeService.class);
        TaskType type = new TaskType();
        type.setTypeName("工作");
        boolean b = bean.addTaskType(type);
        System.out.println(b);
    }
    @Test
    public void selectType(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TaskTypeService bean = ac.getBean(TaskTypeService.class);
//        type.setType_name("工作");
        List<TaskType> list = bean.selectType();
        System.out.println(list);
        for (TaskType taskType : list) {
            System.out.println(taskType.getTypeName());
        }
    }
}
