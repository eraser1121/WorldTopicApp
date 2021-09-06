package com.example.worldtopic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WorldNews extends AppCompatActivity {
    private WebView webview;
    private WebSettings websettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_news);

        webview = (WebView) findViewById(R.id.webview);

        webview.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        websettings = webview.getSettings(); //세부 세팅 등록
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportMultipleWindows(false);
        websettings.setJavaScriptCanOpenWindowsAutomatically(false);
        websettings.setLoadWithOverviewMode(true);
        websettings.setUseWideViewPort(true);
        websettings.setSupportZoom(false);
        websettings.setBuiltInZoomControls(false);
        websettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        websettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        websettings.setDomStorageEnabled(true);

        webview.loadUrl("http://bbc.com/news/world");

        Button btn1 = (Button) findViewById(R.id.newsbtn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://bbc.com/news/world");
            }
        });

        Button btn2 = (Button) findViewById(R.id.newsbtn2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://edition.cnn.com/world");
            }
        });
        Button btn3 = (Button) findViewById(R.id.newsbtn3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                webview.loadUrl("http://nytimes.com/section/world");
            }
        });
    }
}