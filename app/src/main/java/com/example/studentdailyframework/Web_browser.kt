package com.example.studentdailyframework
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.view.animation.Animation
import android.webkit.CookieManager
import android.webkit.URLUtil
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class WebBrowser : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var layNonet: LinearLayout
    private lateinit var progressBar: LottieAnimationView
    private lateinit var layRoot: LinearLayout
    private lateinit var imgBack: ImageView
    private lateinit var webTitle: TextView
    private lateinit var animation: Animation

    private val USER_AGENT_ = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) " +
            "AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19"

    companion object {
        var WEBSITE_LINK = ""
        var WEBSITE_TITLE = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browser)

        progressBar = findViewById(R.id.progressBar)
        layRoot = findViewById(R.id.layRoot)
        layNonet = findViewById(R.id.layNonet)
        imgBack = findViewById(R.id.imgBack)
        webTitle = findViewById(R.id.webTitile)
        animation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.middle_to_top)

        webView = WebView(this)
        webView.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        webView.fitsSystemWindows = false
        webView.isVerticalScrollBarEnabled = false
        webView.setPadding(15, 15, 15, 15)
        layRoot.addView(webView)

        webView.settings.userAgentString = USER_AGENT_
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = HelloWebViewClient()
        webView.webChromeClient = ChromeClient()

        webView.settings.blockNetworkLoads = false
        webView.settings.mediaPlaybackRequiresUserGesture = false
        webView.settings.domStorageEnabled = true

        if (Build.VERSION.SDK_INT >= 19) {
            webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }

        webView.settings.userAgentString = getString(R.string.app_name)

        webView.loadUrl(WEBSITE_LINK)

        if (!isNetworkAvailable(this)) {
            webView.visibility = View.GONE
            layNonet.visibility = View.VISIBLE
        } else {
            webView.visibility = View.VISIBLE
            layNonet.visibility = View.GONE
        }

        webTitle.text = WEBSITE_TITLE
        imgBack.setOnClickListener {
            finish()
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null
    }

    private inner class HelloWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }
    }

    private inner class ChromeClient : WebChromeClient() {

        private var mCustomView: View? = null
        private var mCustomViewCallback: CustomViewCallback? = null
        private var mFullscreenContainer: FrameLayout? = null
        private var mOriginalOrientation = 0
        private var mOriginalSystemUiVisibility = 0

        override fun onProgressChanged(view: WebView, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            if (newProgress >= 100) {
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
            }
        }

        override fun getDefaultVideoPoster(): Bitmap? {
            return mCustomView?.let {
                BitmapFactory.decodeResource(applicationContext.resources, 2130837573)
            }
        }

        override fun onHideCustomView() {
            (window.decorView as FrameLayout).removeView(mCustomView)
            mCustomView = null
            window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
            requestedOrientation = mOriginalOrientation
            mCustomViewCallback?.onCustomViewHidden()
            mCustomViewCallback = null
        }

        override fun onShowCustomView(paramView: View, paramCustomViewCallback: CustomViewCallback) {
            if (mCustomView != null) {
                onHideCustomView()
                return
            }
            mCustomView = paramView
            mOriginalSystemUiVisibility = window.decorView.systemUiVisibility
            mOriginalOrientation = requestedOrientation
            mCustomViewCallback = paramCustomViewCallback
            (window.decorView as FrameLayout).addView(mCustomView, FrameLayout.LayoutParams(-1, -1))
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or 3846
        }
    }

    override fun onBackPressed() {
        if (!webView.canGoBack()) {
            super.onBackPressed()
        } else {
            webView.goBack()
        }
    }

    fun downloadDialog(url: String, userAgent: String, contentDisposition: String, mimetype: String) {
        val filename = URLUtil.guessFileName(url, contentDisposition, mimetype)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Downloading")
        builder.setMessage("We are trying to download: $filename")
        builder.setPositiveButton("Download") { dialog, which ->
            val request = DownloadManager.Request(Uri.parse(url))
            val cookie = CookieManager.getInstance().getCookie(url)
            request.addRequestHeader("Cookie", cookie)
            request.addRequestHeader("User-Agent", userAgent)
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename)
            downloadManager.enqueue(request)

            val onComplete = object : BroadcastReceiver() {
                override fun onReceive(ctxt: Context, intent: Intent) {
                    Toast.makeText(applicationContext, "Download Complete", Toast.LENGTH_SHORT).show()
                }
            }
            registerReceiver(onComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        }
        builder.setNegativeButton("NOT NOW") { dialog, which ->
            dialog.cancel()
            webView.goBack()
        }
        builder.show()
    }
}
