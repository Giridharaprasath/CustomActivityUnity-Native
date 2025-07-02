package com.melonstudios.toastunity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class ToastUnity extends Application {
    public void ShowToast(Context context, final String message, final int duration) {
        new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(context, message, duration).show());
    }
}
