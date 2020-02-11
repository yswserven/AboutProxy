package com.proxy.dynamicproxy;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

import com.proxy.app.APP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by: Ysw on 2020/2/11.
 */
public class DynamicProxyIFactory implements InvocationHandler {

    private Object iToolFactory;
    private Object invoke;

    public DynamicProxyIFactory(Object iToolFactory) {
        this.iToolFactory = iToolFactory;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(iToolFactory.getClass().getClassLoader(), iToolFactory.getClass().getInterfaces(), this);
    }

    private void doBefore() {
        Log.d("Ysw", "doBefore: 动态代理类代理之前的工作");
        Toast.makeText(APP.getContext(), "doBefore: 动态代理类代理之前的工作", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {
        doBefore();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                try {
                    if (millisUntilFinished < 2000 && millisUntilFinished > 1000) {
                        invoke = method.invoke(iToolFactory, args);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFinish() {
                doAfter();
            }
        }.start();
        return invoke;
    }

    private void doAfter() {
        Log.d("Ysw", "doAfter: 动态代理类被代理之后的工作");
        Toast.makeText(APP.getContext(), "doAfter: 动态代理类被代理之后的工作", Toast.LENGTH_SHORT).show();
    }
}
