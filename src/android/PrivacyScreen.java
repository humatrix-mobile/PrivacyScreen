package com.hmc;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import android.content.Context;
import android.os.Bundle;


/**
 * This class echoes a string called from JavaScript.
 */
public class PrivacyScreen extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("enable")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    enable(callbackContext);
                }
            });
            return true;
        }
        else if(action.equals("disable")){
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    disable(callbackContext);
                }
            });
            return true;
        }
        return false;
    }

    private void enable(CallbackContext callbackContext) {
        try {
            Activity activity = this.cordova.getActivity();
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
            callbackContext.success("PrivacyScreen is enable.");
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }

    private void disable(CallbackContext callbackContext) {
        try {
            Activity activity = this.cordova.getActivity();
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
            callbackContext.success("PrivacyScreen is disable.");
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }
}
