package com.proxy.staticproxy;

import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

import com.proxy.app.APP;
import com.proxy.interf.IToolFactory;

/**
 * Created by: Ysw on 2020/2/11.
 */
public class StaticProxyIFactory implements IToolFactory {
    private IToolFactory iToolFactory;

    public StaticProxyIFactory(IToolFactory iToolFactory) {
        this.iToolFactory = iToolFactory;
    }

    private void doBefore() {
        Log.d("Ysw", "doBefore: 静态代理类代理之前的工作");
        Toast.makeText(APP.getContext(), "doBefore: 静态代理类代理之前的工作", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void makeProduct() {
        doBefore();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 2000 && millisUntilFinished > 1000) {
                    iToolFactory.makeProduct();
                }
            }

            @Override
            public void onFinish() {
                doAfter();
            }
        }.start();
    }

    @Override
    public void secondMethod() {
        doBefore();
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished < 2000 && millisUntilFinished > 1000) {
                    iToolFactory.secondMethod();
                }
            }

            @Override
            public void onFinish() {
                doAfter();
            }
        }.start();
    }

    private void doAfter() {
        Log.d("Ysw", "doAfter: 静态代理类被代理之后的工作");
        Toast.makeText(APP.getContext(), "doAfter: 静态代理类被代理之后的工作", Toast.LENGTH_SHORT).show();
    }
}
