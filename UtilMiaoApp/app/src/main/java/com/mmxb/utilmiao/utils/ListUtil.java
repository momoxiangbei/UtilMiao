package com.mmxb.utilmiao.utils;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xueying on 2018/5/2.
 */

public class ListUtil {

    /**
     * Returns a copy of the given list that is safe to iterate over and perform actions that may
     * modify the original list.
     */
    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> other) {
        List<T> result = new ArrayList<>(other.size());
        for (T item : other) {
            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

}
