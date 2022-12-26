package com.liufang.jvm.classloader;

/**
 * @author hengliang.xu@patpat.com
 * @decription
 * @date 2022-12-19-11-39
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl1 = ClassLoaderDemo.class.getClassLoader();
        //cl1 = jdk.internal.loader.ClassLoaders$AppClassLoader@512ddf17
        System.out.println("cl1 = " + cl1);
        //parent of cl1 = jdk.internal.loader.ClassLoaders$PlatformClassLoader@7f690630
        System.out.println("parent of cl1 = " + cl1.getParent());

        ClassLoader cl2 = String.class.getClassLoader();
        //null  ps:BootStrapClassLoader（C++），sun.boot.class.path 目录\jre；是JVM的一部分，不是JAVA类
        System.out.println("cl2 = " + cl2);
        System.out.println(cl1.loadClass("java.util.List").getClass().getClassLoader());//null

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
