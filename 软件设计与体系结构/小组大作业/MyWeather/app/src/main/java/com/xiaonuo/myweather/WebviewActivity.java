package com.xiaonuo.myweather;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebviewActivity extends AppCompatActivity {
    private WebView mWebView;
    private String url = "http://120.79.75.215:8080/aa.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        ActivitiesCollection.addActivity(this);

        mWebView = findViewById(R.id.webview);


        WebSettings settings = mWebView.getSettings();

        settings.setLoadWithOverviewMode(true);
        //设置WebView是否使用预览模式加载界面。
        settings.setTextSize(WebSettings.TextSize.LARGEST);
        //通过设置WebSettings，改变HTML中文字的大小
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        //支持通过JS打开新窗口
//        //设置WebView属性，能够执行Javascript脚本
        mWebView.getSettings().setJavaScriptEnabled(true);
        //设置js可用
        mWebView.addJavascriptInterface(new AndroidJavaScript(getApplication()), "android");
        //设置js接口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //支持内容重新布局


        mWebView.loadUrl(url);
    }

    private class AndroidJavaScript {
        Context mContxt;

        public AndroidJavaScript(Context mContxt) {
            this.mContxt = mContxt;
        }

        @JavascriptInterface
        public String returnAndroid() {//从网页跳回到APP，这个方法已经在上面的HTML中写上了
            Toast.makeText(mContxt, "成功通过调用安卓程序天气XML数据", Toast.LENGTH_LONG).show();

            String string = Utils.getString(mContxt, Constant.WEATHER_JSON_DATA, "");
            return string;
        }
    }
}
