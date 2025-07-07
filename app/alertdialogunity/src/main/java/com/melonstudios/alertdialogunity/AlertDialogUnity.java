package com.melonstudios.alertdialogunity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class AlertDialogUnity extends Application {
    public void ShowAlertDialog(Context context, final String title, final String message, final Boolean showCloseButton, final String actionText) {
        new Handler(Looper.getMainLooper()).post(() -> {
            var alertDialog = new AlertDialog.Builder(context);
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            if (showCloseButton) {
                alertDialog.setCancelable(false);
                alertDialog.setNegativeButton(actionText, (dialog, which) -> {
                });
            }
            alertDialog.create();
            alertDialog.show();
        });
    }
}
