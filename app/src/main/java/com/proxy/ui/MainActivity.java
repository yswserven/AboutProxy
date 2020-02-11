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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 静态代理
     *
     * @author Ysw created at 2020/2/11 23:28
     */
    public void staticProxy(View view) {
        StaticProxyIFactory factory = new StaticProxyIFactory(new StaticIFactory());
        factory.makeProduct();
    }

    /**
     * 动态代理
     *
     * @author Ysw created at 2020/2/11 23:28
     */
    public void dynamicProxy(View view) {
        DynamicProxyIFactory proxyFactory = new DynamicProxyIFactory(new DynamicIFactory());
        IToolFactory proxyInstance = (IToolFactory) proxyFactory.getProxyInstance();
        proxyInstance.makeProduct();
    }
}
