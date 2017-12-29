package cn.fanhub.jysk.spring.bean.impl;

import cn.fanhub.jysk.spring.bean.CglibService;

/**
 * @author chengfan
 * @date 2017-12-22 0:07:31
 */

public class CglibServiceImpl implements CglibService {
    @Override
    public String test() {
        return "test";
    }
}