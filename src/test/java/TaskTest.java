import cn.neu.jing.dao.TaskDao;
import cn.neu.jing.entity.Task;
import cn.neu.jing.service.TaskService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TaskTest {
    @Test
    public void selectById(){
        //获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        从容器中拿到所需的dao的代理对象
        TaskService bean = ac.getBean(TaskService.class);
        Task task = bean.selectById(1);
        System.out.println(task.getTask_name());
    }
}
