/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

import cn.fanhub.Favorite;
import cn.fanhub.FavoriteService;
import cn.fanhub.SuggestionService;
import cn.fanhub.UiList;
import cn.fanhub.UiUtils;
import cn.fanhub.UserService;

import java.util.List;

/**
 *
 * @author chengfan
 * @version $Id: UseCallback.java, v 0.1 2018年03月11日 下午4:33 chengfan Exp $
 */
public class UseCallback {
    public static void main(String[] args) {
        UserService userService = new UserService();
        SuggestionService suggestionService = new SuggestionService();
        FavoriteService favoriteService = new FavoriteService();
        UiList uiList = new UiList();
        String userId = "2";

        
        userService.getFavorites(userId, new CallBack<List<String>>() {
            public void onSuccess(List<String> list) {
                if (list.isEmpty()) {
                    suggestionService.getSuggestions(new CallBack<List<Favorite>>() {
                        public void onSuccess(List<Favorite> list) {
                            UiUtils.submitOnUiThread(() ->
                                list.stream()
                                    .limit(5)
                                    .forEach(uiList::show)
                            );
                        }

                        public void onError(Throwable error) {
                            UiUtils.errorPopup(error);
                        }
                    });
                } else {
                    list.stream()
                        .limit(5)
                        .forEach(favId -> favoriteService.getDetails(favId,
                            new CallBack<Favorite>() {
                                public void onSuccess(Favorite details) {
                                    UiUtils.submitOnUiThread(() -> uiList.show(details));
                                }

                                public void onError(Throwable error) {
                                    UiUtils.errorPopup(error);
                                }
                            }
                        ));
                }
            }

            public void onError(Throwable error) {
                UiUtils.errorPopup(error);
            }
        });

    }
}