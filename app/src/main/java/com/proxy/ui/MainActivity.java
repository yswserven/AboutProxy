package com.proxy.ui;

import android.os.Bundle;
import android.view.View;

import com.proxy.R;
import com.proxy.dynamicproxy.DynamicIFactory;
import com.proxy.dynamicproxy.DynamicProxyIFactory;
import com.proxy.interf.IToolFactory;
import com.proxy.staticproxy.StaticIFactory;
import com.proxy.staticproxy.StaticProxyIFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private StaticProxyIFactory factory;
    private DynamicProxyIFactory proxyFactory;
    private IToolFactory proxyInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* 获取静态代理类对象 @author Ysw created 2020/2/13 */
        factory = new StaticProxyIFactory(new StaticIFactory());
        /* 获取动态代理中介类对象 @author Ysw created 2020/2/13 */
        proxyFactory = new DynamicProxyIFactory(new DynamicIFactory());
        /* 获取代理对象 @author Ysw created 2020/2/13 */
        proxyInstance = (IToolFactory) proxyFactory.getProxyInstance();
    }

    /**
     * 静态代理调用方法一
     *
     * @author Ysw created at 2020/2/11 23:28
     */
    public void staticProxy(View view) {
        factory.makeProduct();
    }

    /**
     * 动态代理调用方法一
     *
     * @author Ysw created at 2020/2/11 23:28
     */
    public void dynamicProxy(View view) {
        proxyInstance.makeProduct();
    }

    /**
     * 静态代理调用方法二
     *
     * @author Ysw created at 2020/2/13 1:31
     */
    public void staticProxyTwo(View view) {
        factory.secondMethod();
    }

    /**
     * 动态代理调用方法二
     *
     * @author Ysw created at 2020/2/13 1:33
     */
    public void dynamicProxyTwo(View view) {
        proxyInstance.secondMethod();
    }
}
