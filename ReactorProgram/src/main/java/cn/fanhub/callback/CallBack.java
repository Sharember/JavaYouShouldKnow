/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub.callback;

/**
 *
 * @author chengfan
 * @version $Id: CallBack.java, v 0.1 2018年03月11日 下午4:32 chengfan Exp $
 */
public interface CallBack<T> {
    void onSuccess(T t);
    void onError(Throwable error);
}