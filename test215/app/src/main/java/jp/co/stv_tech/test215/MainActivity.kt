@file:Suppress("DEPRECATION")

package jp.co.stv_tech.test215

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MainActivity", "onCreate")

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()

        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if ( networkInfo != null && networkInfo.isConnected ) {
            webView.loadUrl("https://www.amazon.co.jp/")
        } else {
            val textView: TextView = findViewById(R.id.lvText)
            textView.setText(R.string.tvText)
        }

        val lvGoBack = findViewById<Button>(R.id.lvGoBack)
        val lvGoForward = findViewById<Button>(R.id.lvGoForward)
        val lvReload = findViewById<Button>(R.id.lvReload)

        lvGoBack.setOnClickListener(this)
        lvGoForward.setOnClickListener(this);
        lvReload.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        if (v == lvGoBack) {

            if (webView.canGoBack()) {
                webView.goBack();
            }
        } else if (v == lvGoForward) {

            if (webView.canGoForward()) {
                webView.goForward();
            }
        } else if (v == lvReload) {
            
            webView.reload();
        }
    }
}


