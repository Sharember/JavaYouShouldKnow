/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub;

/**
 *
 * @author chengfan
 * @version $Id: Favorite.java, v 0.1 2018年03月11日 下午4:37 chengfan Exp $
 */
public class Favorite {
    private long id;
    private String name;

    public Favorite(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}