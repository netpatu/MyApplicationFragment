package test.zlive.grtn.com.myapplicationfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import test.zlive.grtn.com.myapplicationfragment.view.SafeWebView;

/**
 * Created by hp on 2018/1/8.
 */

public class WebViewActivity extends Activity {

    SafeWebView mWebView;

    String mUrl2 = "file:///android_asset/test.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);

        mWebView = findViewById(R.id.web_view);

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);//设置与JS交互的权限

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置允许JS弹窗

        mWebView.addJavascriptInterface(new JSInterface(), "jsInterface");

//        mWebView.loadUrl("file:///android_asset/javascript.html");

        mWebView.loadUrl(mUrl2);
    }

    public void onWebClick(View view) {
        callJSevaluateJavaScript();
    }

    /**
     * 效率高,避免调用js事件导致页整体刷新
     */
    private void callJSevaluateJavaScript() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.evaluateJavascript("javascript:writeContents('<h1>This is a heading</h1>','<p>This is a paragraph</p>')", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    Log.d("WebView Call Js", "value = " + value);
                }
            });

            return;
        }

        callJSLoadUrl();
    }

    /**
     * 这种方法会使叶面刷新
     */
    private void callJSLoadUrl() {
        mWebView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWebView.loadUrl("javascript:callJS()");
            }
        }, 3 * 1000l);

        /***
         *    由于设置了弹窗来检验调用结果,所以需要支持js对话框
         *    webview只是载体，内容的渲染需要使用webviewChromClient类去实现
         *    通过设置WebChromeClient对象处理JavaScript的对话框
         *    设置响应js 的Alert()函数
         */
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(WebViewActivity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();

                return true;
            }
        });
    }

    class JSInterface {
        @JavascriptInterface
        public String onButtonClick(String text) {
            final String str = text;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.e("leehong2", "onButtonClick: text = " + str);
                    Toast.makeText(getApplicationContext(), "onButtonClick: text = " + str, Toast.LENGTH_LONG).show();
                }
            });

            return "This text is returned from Java layer.  js text = " + text;
        }

        @JavascriptInterface
        public void onImageClick(String url, int width, int height) {
            final String str = "onImageClick: text = " + url + "  width = " + width + "  height = " + height;
            Log.i("leehong2", str);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
