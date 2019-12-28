import cn.neu.jing.dao.TaskTypeDao;
import cn.neu.jing.entity.TaskType;
import cn.neu.jing.service.TaskTypeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println(type.getType_name());
    }

}
