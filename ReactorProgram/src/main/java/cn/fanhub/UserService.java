/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

import cn.fanhub.Favorite;
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
    void getFavorites(String userID, CallBack callBack) {
        if ("1".equals(userID)) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(i + "");
            }
            callBack.onSuccess(list);
        } else {
            callBack.onSuccess(Collections.emptyList());
        }
    }

    public Flux<Favorite> getFavorites(String userId) {
        if ("1".equals(userId)) {
            List<Favorite> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new Favorite(i, "flux" + i));
            }
            return Flux.fromIterable(list);
        } else {
            return Flux.fromIterable(Collections.emptyList());
        }
    }
}