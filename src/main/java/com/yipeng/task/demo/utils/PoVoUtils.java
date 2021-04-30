package com.yipeng.task.demo.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * @Author: yipeng
 * @Date: 2021/4/30 0:37
 */
public class PoVoUtils {

    public static <T1, T2> T2 transfer(T1 from, Class<T2> toClass, String... ignoreProperties) {
        return transfer(from, toClass, null, ignoreProperties);
    }

    public static <T1, T2> T2 transfer(T1 from, Class<T2> toClass, AfterTransfer<T1, T2> at, String... ignoreProperties) {
        T2 to;
        try {
            to = toClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(from, to, ignoreProperties);
        if (at != null) {
            at.apply(from, to);
        }
        return to;
    }

    public static <P, V> List<V> transferList(List<P> list, Class<V> vclass, AfterTransfer<P, V> afterPo2Vo) {
        List<V> lst = null;
        if (list != null && list.size() > 0) {
            List<V> flst = new LinkedList<>();
            list.forEach(p -> {
                V v = transfer(p, vclass, afterPo2Vo);
                flst.add(v);
            });
            lst = flst;
        }

        return lst;
    }

    public static interface AfterTransfer<T1, T2> {
        void apply(T1 t1, T2 t2);
    }

}
