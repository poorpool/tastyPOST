package net.yxchen.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 把一个 parameterMap 转化成 bean 对象
     * @param map parameterMap
     * @param bean bean 对象
     * @param <T> bean 对象泛型
     * @return 转化的 bean 对象
     */
    public static <T> T copyParamToBean(Map map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
