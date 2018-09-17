package com.epc.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeanUtils {
    /**
     * @Author :winlin
     * @Description :利用反射复制不同类相同属性的复制,化不同为相同
     * @Date:2018/9/13
     */
    public static void copyPropertise(Object source, Object target, String... exclusion) {
        //获取源文件的反射对象
        Class sourceClass = source.getClass();
        //获取目标文件的反射对象
        Class targetClass = target.getClass();
        //获得源文件的所有字段
        Field[] sourceFields = sourceClass.getDeclaredFields();
        //获得目标文件的所有字段
        Field[] targetFields = targetClass.getDeclaredFields();
        //遍历字段依次调用get和set,获得需要复制的字段
        List<Field> fieldNeedCopy = Arrays.asList(sourceFields);
        if (exclusion.length > 0) {
            for (Field sourceField : sourceFields) {
                //获得源文件的属性名
                String name = sourceField.getName();
                for (String str : exclusion) {
                    if (name.equalsIgnoreCase(str)) {
                        fieldNeedCopy.remove(sourceField);
                    }
                }
            }
        }
        for (Field sourceField : fieldNeedCopy) {
            //属性名
            String name = sourceField.getName();
            //属性类型
            Class type = sourceField.getType();
            //拼接方法名
            String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            try {
                //得到name的get方法
                Method method = sourceClass.getMethod(methodName, type.getClass());
                //调用get方法得到结果
                Object value = method.invoke(source);
                for (Field targetField : fieldNeedCopy) {
                    //目标对象的属性名
                    String targetName = targetField.getName();
                    //目标对象的属性类型
                    Class aClass = targetField.getType();
                    String targetMethodName = "set" + targetName.substring(0, 1).toUpperCase() + targetName.substring(1);
                    //找到set方法
                    Method setMethod1 = targetClass.getMethod(targetMethodName, aClass.getClass());
                    //寻找相同属性名
                    if (targetName.equals(name)) {
                        setMethod1.invoke(target, value);
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
