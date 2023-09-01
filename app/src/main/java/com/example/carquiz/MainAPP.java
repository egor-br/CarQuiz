package com.example.carquiz;


import android.app.Application;
import android.util.Log;

import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

public class MainAPP extends Application{
    private static final String YANDEX_MOBILE_ADS_TAG = "YandexMobileAds";
    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this, new InitializationListener() {
            @Override
            public void onInitializationCompleted() {
                Log.d(YANDEX_MOBILE_ADS_TAG, "SDK initialized");
            }
        });
    }

}
