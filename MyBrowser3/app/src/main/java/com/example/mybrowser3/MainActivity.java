package com.example.mybrowser3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public Button btnGo;
    public Button btnBack;
    public Button btnForward;
    public EditText inputUrl;
    public WebView mainView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainView = (WebView) findViewById(R.id.mainView);
        mainView.setWebViewClient(new MyBrowser3());
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUrl();
            }
        });
    }
    private String getinputUrl ()
    {
        inputUrl = (EditText) findViewById(R.id.txtinputUrl);
        String url;
        url = inputUrl.getText().toString();
        return url;
    }
    private void showUrl()
    {
        String url;
        url = getinputUrl();
        mainView.getSettings().setLoadsImagesAutomatically(true);
        mainView.getSettings().setJavaScriptEnabled(true);
        mainView.setScrollBarStyle(mainView.getScrollBarStyle());
        mainView.loadUrl(url);
    }
    private class MyBrowser3 extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String Url)
        {
            view.loadUrl(Url);
            inputUrl.setText(Url);
            return true;
        }
    }

}
