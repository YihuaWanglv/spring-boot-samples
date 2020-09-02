package com.qkc.bus.phoenix.core;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用对象实例转换
 */
public class ModelDefaultTransfer {

    public static <S, T> T transfer(S s, Class<T> cls) {
        T target = ModelDefaultTransfer.getNewObject(cls);
        BeanUtils.copyProperties(s, target);
        return target;
    }

    public static <S, T> List<T> transferList(List<S> list, Class<T> cls) {
        List<T> results = new ArrayList<>();
        for (S s : list) {
            T target = ModelDefaultTransfer.getNewObject(cls);
            BeanUtils.copyProperties(s, target);
            results.add(target);
        }
        return results;
    }

    private static <T> T getNewObject(Class<T> cls) {
        T t = null;
        try {
            t = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
