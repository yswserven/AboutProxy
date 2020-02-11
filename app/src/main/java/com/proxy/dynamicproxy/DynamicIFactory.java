package com.proxy.dynamicproxy;

import android.util.Log;
import android.widget.Toast;

import com.proxy.app.APP;
import com.proxy.interf.IToolFactory;

/**
 * Created by: Ysw on 2020/2/11.
 */
public class DynamicIFactory implements IToolFactory {
    @Override
    public void makeProduct() {
        Log.d("Ysw", "makeProduct: 这个是被代理的对象");
        Toast.makeText(APP.getContext(), "makeProduct: 这个是被代理的对象", Toast.LENGTH_SHORT).show();
    }
}
