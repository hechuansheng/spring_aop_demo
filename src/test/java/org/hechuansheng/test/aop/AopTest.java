package org.hechuansheng.test.aop;

import org.hechuansheng.demo.aop.MainApplication;
import org.hechuansheng.demo.aop.controller.UserController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : hechuansheng
 * @date : 2021/4/20 9:36
 * @description :
 */
public class AopTest {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);

//        printBeanDefinitionNames(context);

        UserController controller = context.getBean(UserController.class);

        controller.login("hechuansheng", "123456");
        controller.refreshToken("token1");
        controller.loginOut();
    }

    private void printBeanDefinitionNames(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
