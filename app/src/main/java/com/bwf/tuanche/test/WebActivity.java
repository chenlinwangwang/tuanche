package com.bwf.tuanche.test;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.tuanche.R;

public class WebActivity extends AppCompatActivity {

    private WebView test_webview;
    private boolean isfirst;
    private String FirstUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        test_webview = (WebView) findViewById(R.id.test_webview);
        test_webview.loadUrl("https://www.baidu.com");//写到这里他会用你的默认浏览器去条指定网页
        //要保证就在当前app跳转页面就必须执行setWebViewClient()方法
        test_webview.setWebViewClient(new MyWebViewClient());
        //重写WebChromeCilent  用于获得网页加载进度
        test_webview.setWebChromeClient(new MyWebChromeClient());

        //设置滚动条样式
        test_webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        test_webview.setHorizontalScrollBarEnabled(false);



    }

    public class MyWebChromeClient extends WebChromeClient{

        //网页加载的进度
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            Log.e("网页加载进度",newProgress+"");


        }

        /**
         * 提示框
         */
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            //此处可以弹出dialog
            return true;
        }

        /**
         * 警告框
         * @return
         */
        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            //此处可以弹出警告弹框
            return true;
        }

    }



    public class MyWebViewClient extends WebViewClient{

        /**
         * 保证在本页面跳转
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            test_webview.loadUrl(url);
            if (!isfirst)
            {
                isfirst = true;
                WebActivity.this.FirstUrl = url;
            }
            //开始第一次加载页面的时候 获得第一次加载页面的url

            return false;
        }

        //网页开始加载（可在其中加入加载动画或者progresbar）
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        //网页加载完成
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    //按下键的判断与操作  重写返回键的功能
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK){//案件被按下并且按下的是返回键
            if (test_webview.canGoBack() && !test_webview.getUrl().equals(FirstUrl) ){//如果网页可以回退  并且 已经回到了以一次加载的页面
                test_webview.goBack();
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
