package net.yxchen.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * 从字符串取得数字
     * @param str 要取得数字的字符串
     * @param defaultInt 如果取得失败，默认返回的值
     * @return 取得结果
     */
    public static Integer pasreInt(String str, Integer defaultInt) {
        if (str == null) {
            return defaultInt;
        }
        Integer result = defaultInt;
        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            ;
        }
        return result;
    }

    /**
     * 把逗号分割的字符串转化为 int 的 List
     * @param str 要转化的字符串
     * @return 转化的 list
     */
    public static List<Integer> parseStringToIntListByComma(String str) {
        String[] strs = str.split(",");
        List<Integer> list = new ArrayList<>();
        for(String string : strs) {
            list.add(pasreInt(string.trim(), 0));
        }
        return list;
    }
}
