package com.mc7.mycustomapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mc7.mycustomapp.databinding.FragmentWebviewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            webView.settings.javaScriptEnabled = true

            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    Toast.makeText(
                        requireActivity(),
                        "Web Dicoding berhasil dimuat",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: android.webkit.JsResult
                ): Boolean {
                    Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
                    result.confirm()

                    return true
                }
            }

            webView.loadUrl("https://www.dicoding.com")
        }
    }
}