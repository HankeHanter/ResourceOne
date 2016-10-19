package com.example.testwebview;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String url = "http://192.168.70.128:3001/center/proxy/partner/v1/pay.jsp?";
//    private String url = "http://192.168.70.128:3001/center/proxy/partner/v1/wap/quickPayList.jsp";

    private String params = "version=v1" + "&partnerId=0755000001" + "&orderId=20160831100448" + "&goods=s+TWtQ=="
            + "&amount=100" + "&expTime=" + "&notifyUrl=" + "&pageUrl=" + "&reserve=" + "&extendInfo=" + "&payMode=08"
            + "&bankId=QPCFTX" + "&creditType=2" + "&custno=U000000001" + "&holderName=1cXI/Q=="
            + "&idNo=111111111111111111&mobile=13999999999&key=12348314-9388-11de-b73f-0f19974d6b20" +
            "&sign=5d8a5cf711944a12fc023b4dd421c5ce";

    private String pa = "version=v1&partnerId=0755000001&orderId=20160831100910&goods=s+TWtQ==&amount=100&expTime=&notifyUrl=&pageUrl=&reserve=&extendInfo=&payMode=07&bankId=QPCFTX&creditType=2&custno=U000000001&holderName=1cXI/Q==&idNo=111111111111111111&mobile=13999999999&key=12348314-9388-11de-b73f-0f19974d6b20&sign=62394bf6bc834075195c3db2aa12e082";


    private String bankUrl = "http://192.168.70.128:3001/center/proxy/partner/v1/querybankcard.jsp";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                WebResourceResponse response = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    response = super.shouldInterceptRequest(view, url);
                    if (url.contains("home.css")) {
                        try {
                            InputStream inputStream = MainActivity.this.getResources().getAssets().open("home.css");
                            response = new WebResourceResponse("text/css", "UTF-8", inputStream);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (url.contains("ariel-all.css")) {
                        try {
                            InputStream inputStream = MainActivity.this.getResources().getAssets().open("ariel-all.css");
                            response = new WebResourceResponse("text/css", "UTF-8", inputStream);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                ;
                return response;
            }

          /*  @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                WebResourceResponse response = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    response = super.shouldInterceptRequest(view,request);
                    if (url.contains("home.css")) {
                        try {
                            response = new WebResourceResponse("text/css","UTF-8",getAssets().open("home.css"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                return response;
            }*/
        });
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
//        mWebView.loadUrl("http://m.ewj.com");
        mWebView.loadUrl(url + pa);
//        new TnThread().start();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
        }
        return super.onKeyUp(keyCode, event);
    }

    class TnThread extends Thread {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            super.run();
            URL threadUrl;
            try {
                threadUrl = new URL(url + params);
                // 2、创建连接
                HttpURLConnection urlconn = (HttpURLConnection) threadUrl.openConnection();
                // 3、设置请求方式
                urlconn.setRequestMethod("GET");
                // 打开连接
                urlconn.connect();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
