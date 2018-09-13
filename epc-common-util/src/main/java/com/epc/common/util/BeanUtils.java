package com.epc.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
/**
 *@Author :winlin
 *@Description :利用反射复制不同类相同属性的复制
 *@Date:2018/9/13
 */
    public static void copyPropertise(Object source,Object target){
        //获取源文件的反射对象
        Class sourceClass = source.getClass();
        //获取目标文件的反射对象
        Class targetClass = target.getClass();
        //获得源文件的所有字段
        Field[] sourceFields = sourceClass.getDeclaredFields();
        //获得目标文件的所有字段
        Field[] targetFields = targetClass.getDeclaredFields();
        //遍历字段依次调用get和set
        for(Field sourceField : sourceFields){
            //属性名
            String name = sourceField.getName();
            //属性类型
            Class type = sourceField.getType();
            //拼接方法名
            String methodName = "get"+name.substring(0,1).toUpperCase()+name.substring(1);
            try {
                 //得到name的get方法
                Method method = sourceClass.getMethod(methodName,type.getClass());
                //调用get方法得到结果
                Object value = method.invoke(source);
                for(Field targetField : targetFields){
                    //目标对象的属性名
                    String targetName = targetField.getName();
                    //目标对象的属性类型
                    Class aClass = targetField.getType();
                    String targetMethodName = "set"+targetName.substring(0,1).toUpperCase()+targetName.substring(1);
                    //找到set方法
                    Method setMethod1 = targetClass.getMethod(targetMethodName,aClass.getClass());
                    //寻找相同属性名
                    if(targetName.equals(name)){
                        setMethod1.invoke(target,value);
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
