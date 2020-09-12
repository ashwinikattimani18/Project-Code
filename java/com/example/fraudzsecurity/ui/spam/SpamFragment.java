package com.example.fraudzsecurity.ui.spam;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.fraudzsecurity.R;

public class SpamFragment extends Fragment {

    private SpamViewModel spamViewModel;




    WebView webView1;
    ProgressDialog progressBar;

    @SuppressLint("ResourceAsColor")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.spam_fragment, container, false);

        webView1 = (WebView)root.findViewById(R.id.webv_spam);
        progressBar = new ProgressDialog(getActivity());
        startLoadData();


        return root;

    }

    private void startLoadData() {
        progressBar.setCancelable(false);
        progressBar.setMessage("Fetching Transactions..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
        loadData();
    }
    private void loadData(){

        progressBar.hide();

       webView1.getSettings().setJavaScriptEnabled(true);//enable javascript
       webView1.setWebViewClient(new WebViewClient());//important open url in app
       webView1.loadUrl("https://www.kaggle.com/mlg-ulb/creditcardfraud");

    }




}


