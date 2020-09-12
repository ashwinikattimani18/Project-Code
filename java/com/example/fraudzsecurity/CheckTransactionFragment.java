package com.example.fraudzsecurity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckTransactionFragment extends Fragment {

    public CheckTransactionFragment() {
        // Required empty public constructor
    }

    WebView webView2;
    ProgressDialog progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_transaction, container, false);

        webView2 = (WebView)view.findViewById(R.id.webv_checktrans);
        progressBar = new ProgressDialog(getActivity());
        startLoadData();

        return view;
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

        webView2.getSettings().setJavaScriptEnabled(true);//enable javascript
        webView2.setWebViewClient(new WebViewClient());//important open url in app
        webView2.loadUrl("https://www.kaggle.com/mlg-ulb/creditcardfraud");
    }
}
