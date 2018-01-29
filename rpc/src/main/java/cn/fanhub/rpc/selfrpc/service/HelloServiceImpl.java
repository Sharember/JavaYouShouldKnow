package cn.fanhub.rpc.selfrpc.service;

public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "hello: " + name;
    }
}