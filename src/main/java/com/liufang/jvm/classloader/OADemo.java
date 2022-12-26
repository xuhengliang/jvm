package com.liufang.jvm.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author hengliang.xu@patpat.com
 * @decription
 * @date 2022-12-19-11-39
 */
public class OADemo {
    public static void main(String[] args) throws Exception {
        Double salary  = 2000.00;
        Double money;
//        URL url = new URL("file:/Users/xuhengliang/usr/local/IdeaProjects/mine/jump/jvm/target/jvm-1.0-SNAPSHOT.jar");
//        URLClassLoader ucl = new URLClassLoader(new URL[]{url});
        SalaryClassLoader scl = new SalaryClassLoader("//Users/xuhengliang/usr/local/IdeaProjects/mine/jump/jvm/target/classes/com/liufang/jvm/classloader/SalaryCaler");
        while (true) {
//            money = calSalary(salary,ucl);
            money = calSalary(salary,scl);
            System.out.println("收钱：" + money);
            Thread.sleep(1000l);
        }
    }

    private static Double calSalary(Double salary,ClassLoader classLoader) throws Exception {
//        SalaryCaler salaryCaler = new SalaryCaler();
//        return salaryCaler.cal(salary);
        Class<?> clazz = classLoader.loadClass("com.liufang.jvm.classloader.SalaryCaler");
        Object obj = clazz.newInstance();
        Object cal = clazz.getMethod("cal", Double.class).invoke(obj, salary);
        return (Double) cal;
    }
}
