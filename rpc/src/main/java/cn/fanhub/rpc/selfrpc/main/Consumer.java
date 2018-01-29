package cn.fanhub.rpc.selfrpc.main;

import cn.fanhub.rpc.selfrpc.framework.ConsumerProxy;
import cn.fanhub.rpc.selfrpc.service.HelloService;

public class Consumer {
    public static void main(String[] args) throws Exception {
        HelloService service = ConsumerProxy.consume(HelloService.class, "localhost", 8888);

        for (int i = 0; i < 10; i++) {
            String hello = service.hello("hhh_" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }
}