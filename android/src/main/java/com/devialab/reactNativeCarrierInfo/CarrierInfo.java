package com.devialab.reactNativeCarrierInfo;

import android.content.Context;

import android.telephony.TelephonyManager;

import com.facebook.react.bridge.*;


public class CarrierInfo extends ReactContextBaseJavaModule  {

    public CarrierInfo(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNCarrierInfo";
    }

    @ReactMethod
    public void isoCountryCode(Callback successCallback, Callback errorCallback) throws Exception {
        String isoCountryCode = null;

        try {
            TelephonyManager mTelephonyManager = (TelephonyManager) getReactApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
            isoCountryCode = mTelephonyManager.getSimCountryIso();
        }catch(Exception e) {
            errorCallback.invoke(e.getMessage());
        }
        successCallback.invoke(isoCountryCode);
    }



}
