/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub;

import cn.fanhub.callback.CallBack;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: UserService.java, v 0.1 2018年03月11日 下午4:34 chengfan Exp $
 */
public class UserService {
    public void getFavorites(String userID, CallBack callBack) {
        new Thread(() -> {
            if ("1".equals(userID)) {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add(i + "");
                }
                callBack.onSuccess(list);
            } else {
                callBack.onSuccess(Collections.emptyList());
            }
        }).start();
    }

    public Flux<String> getFavorites(String userId) {
        if ("1".equals(userId)) {
            return Flux.generate(() -> 0, (state, sink) -> {
                    sink.next(state + "");
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                });
        } else {
            return Flux.fromIterable(Collections.emptyList());
        }
    }
}