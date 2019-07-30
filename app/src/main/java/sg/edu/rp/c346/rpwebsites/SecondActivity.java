package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends MainActivity{

    WebView wvmypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intentReceived = getIntent();
        String finale = intentReceived.getStringExtra("url");

        wvmypage = findViewById(R.id.webview);
        wvmypage.setWebViewClient(new WebViewClient());

        String url = finale;
        WebSettings testing=wvmypage.getSettings();
        testing.setCacheMode(WebSettings.LOAD_NO_CACHE);
        testing.setJavaScriptEnabled(true);
        testing.setAllowFileAccessFromFileURLs(false);
        testing.setBuiltInZoomControls(true);

        wvmypage.loadUrl(url);

        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();
    }
}
