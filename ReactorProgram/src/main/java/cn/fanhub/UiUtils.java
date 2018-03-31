/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 *
 * @author chengfan
 * @version $Id: UiUtils.java, v 0.1 2018年03月11日 下午4:40 chengfan Exp $
 */
public class UiUtils {


    public static void errorPopup(Throwable error) {
        System.out.println(error);
    }

    public static void submitOnUiThread(NoParamFunction function) {
        new Thread(function::apply).start();
    }

    public static Scheduler uiThreadScheduler() {
        return Schedulers.elastic();
    }
}