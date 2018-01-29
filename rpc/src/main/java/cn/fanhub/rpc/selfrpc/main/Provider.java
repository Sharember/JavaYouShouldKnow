package cn.fanhub.rpc.selfrpc.main;

import cn.fanhub.rpc.selfrpc.framework.ProviderReflect;
import cn.fanhub.rpc.selfrpc.service.HelloService;
import cn.fanhub.rpc.selfrpc.service.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        ProviderReflect.provider(service, 8888);
    }
}