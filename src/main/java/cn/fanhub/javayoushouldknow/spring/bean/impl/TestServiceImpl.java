package cn.fanhub.javayoushouldknow.spring.bean.impl;

import cn.fanhub.javayoushouldknow.spring.bean.TestService;

/**
 * @author chengfan
 * @date 2017-12-22 0:07:31
 */

public class TestServiceImpl implements TestService{
    @Override
    public String test() {
        return "test";
    }
}