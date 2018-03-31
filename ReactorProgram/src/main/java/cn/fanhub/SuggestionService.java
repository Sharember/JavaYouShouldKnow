/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

import cn.fanhub.Favorite;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: SuggestionService.java, v 0.1 2018年03月11日 下午4:38 chengfan Exp $
 */
public class SuggestionService {
    void getSuggestions(CallBack callBack){
        List<Favorite> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Favorite(i, "sss" + i));
        }
        callBack.onSuccess(list);
    }

    public Flux<Favorite> getSuggestions() {
        List<Favorite> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Favorite(i, "sss" + i));
        }
        return Flux.fromIterable(list);
    }
}