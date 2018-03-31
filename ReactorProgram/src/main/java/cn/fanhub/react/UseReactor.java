/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.react;

import cn.fanhub.FavoriteService;
import cn.fanhub.SuggestionService;
import cn.fanhub.UiList;
import cn.fanhub.UiUtils;
import cn.fanhub.UserService;

/**
 *
 * @author chengfan
 * @version $Id: Reactor.java, v 0.1 2018年03月11日 下午5:49 chengfan Exp $
 */
public class Reactor {

    public static void main(String[] args) {
        UserService userService = new UserService();
        SuggestionService suggestionService = new SuggestionService();
        FavoriteService favoriteService = new FavoriteService();
        UiList uiList = new UiList();
        String userId = "1";

        userService
            .getFavorites(userId)
            .switchIfEmpty(suggestionService.getSuggestions())
            .take(5)
            .flatMap(favoriteService::getDetails)
            .publishOn(UiUtils.uiThreadScheduler())
            .subscribe(uiList::show, UiUtils::errorPopup);
    }
}