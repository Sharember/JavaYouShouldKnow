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
public class TestCglibProxy {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/aop.xml");
        CglibService cglibService = (CglibService) context.getBean("cglibService");
        System.err.println(cglibService.getClass().getName());
        Class<?>[] interfaces = cglibService.getClass().getInterfaces();

        System.err.println("+-----------------------cglibService----------------------------------+");
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }
        System.err.println("+-----------------------cglibService resource----------------------------------+");

        interfaces = getResourceTarget(cglibService).getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.err.println(anInterface);
        }

        System.err.println("+-----------------------cglibService resource method2----------------------------------+");

        interfaces = cglibService.getClass().getSuperclass().getInterfaces();
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

    /**
     * 结果:
     *
     cn.fanhub.javayoushouldknow.spring.bean.impl.CglibServiceImpl$$EnhancerBySpringCGLIB$$b50f26e
     +-----------------------cglibService----------------------------------+
     interface org.springframework.aop.SpringProxy
     interface org.springframework.aop.framework.Advised
     interface org.springframework.cglib.proxy.Factory
     +-----------------------cglibService resource----------------------------------+
     interface cn.fanhub.javayoushouldknow.spring.bean.CglibService
     +-----------------------cglibService resource method2----------------------------------+
     interface cn.fanhub.javayoushouldknow.spring.bean.CglibService
     +-----------------------jdkService----------------------------------+
     interface cn.fanhub.javayoushouldknow.spring.bean.JdkService
     +-----------------------normalService----------------------------------+
     interface cn.fanhub.javayoushouldknow.spring.bean.NormalService
     *
     */

    private Object getResourceTarget(Object beanInstance) {
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