/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub;

import reactor.core.publisher.Signal; /**
 *
 * @author chengfan
 * @version $Id: UiList.java, v 0.1 2018年03月11日 下午4:45 chengfan Exp $
 */
public class UiList {
    public void show(Favorite t) {
        System.out.println(Thread.currentThread().getId() + " => " + t.getName());
    }

    public void show(String s) {
        System.out.println(Thread.currentThread().getId() + " => " + s);
    }

    public void showThread() {
        System.out.println("thread: => " + Thread.currentThread().getId());
    }

    public void showThread(Signal<Favorite> favoriteSignal) {
        System.out.println("thread: => " + Thread.currentThread().getId());
    }
}