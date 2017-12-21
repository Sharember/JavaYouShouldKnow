package cn.fanhub.javayoushouldknow.spring.aop.cglibProblem;

import cn.fanhub.javayoushouldknow.spring.bean.TestService;
import org.junit.Test;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;

/**
 * @author chengfan
 * @date 2017-12-22 0:26:30
 */
public class TestCglib {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/aop.xml");
        TestService testService = (TestService) context.getBean("testService");
        Class<?>[] interfaces = testService.getClass().getInterfaces();

        System.err.println("+---------------------------------------------------------+");
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }
        System.err.println("+---------------------------------------------------------+");

        interfaces = getTarget(testService).getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }
    }

    private Object getTarget(Object beanInstance) {
        if (AopUtils.isCglibProxy(beanInstance)) {
            try {
                Field h = beanInstance.getClass().getDeclaredField("CGLIB$CALLBACK_0");
                h.setAccessible(true);
                Object dynamicAdvisedInterceptor = h.get(beanInstance);

                Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
                advised.setAccessible(true);

                Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
                return target;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return beanInstance;
    }
}