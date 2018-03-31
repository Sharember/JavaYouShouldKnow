/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author chengfan
 * @version $Id: FavoriteService.java, v 0.1 2018年03月11日 下午4:44 chengfan Exp $
 */
public class FavoriteService {

    private Map<String, Favorite> map = new ConcurrentHashMap<>();

    {
        for (int i = 0; i < 10; i++) {
            map.put(i + "", new Favorite(i, "a" + i));
        }
    }

    public void getDetails(String id, CallBack callBack){
        callBack.onSuccess(map.get(id));
    }

    public Mono<String> getDetails(Favorite favorite) {
        return Mono.just(favorite.getName());
    }
}