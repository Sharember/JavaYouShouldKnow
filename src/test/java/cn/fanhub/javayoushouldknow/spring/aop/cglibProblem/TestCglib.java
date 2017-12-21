package cn.fanhub.javayoushouldknow.spring.aop.cglibProblem;

import cn.fanhub.javayoushouldknow.spring.bean.CglibService;
import cn.fanhub.javayoushouldknow.spring.bean.JdkService;
import cn.fanhub.javayoushouldknow.spring.bean.NormalService;
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
        CglibService cglibService = (CglibService) context.getBean("cglibService");
        Class<?>[] interfaces = cglibService.getClass().getInterfaces();

        System.err.println("+-----------------------cglibService----------------------------------+");
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }
        System.err.println("+-----------------------cglibService resource----------------------------------+");

        interfaces = getTarget(cglibService).getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }

        System.err.println("+-----------------------jdkService----------------------------------+");
        JdkService jdkService = (JdkService) context.getBean("jdkService");
        interfaces = jdkService.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }

        System.err.println("+-----------------------normalService----------------------------------+");

        NormalService normalService = (NormalService) context.getBean("normalService");
        interfaces = normalService.getClass().getInterfaces();
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