package com.liufang.jvm.classloader;

import java.security.SecureClassLoader;

/**
 * @author hengliang.xu@patpat.com
 * @decription 从myclass文件中加载对象
 * @date 2022-12-19-11-39
 */
public class SalaryClassLoader extends SecureClassLoader {
    // 文件路径
    private String classPath;

    public SalaryClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b;

//        return this.defineClass(name,b,0,b.length);
        return super.findClass(name);
    }
}
