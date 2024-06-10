package com.example.androidinternship;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class CommonMethod {

    public CommonMethod(Sign_up sign_up, String toString) {
    }

    // Method to show a Toast message
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    // Method to show a Snackbar message
    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    // Method to start the DashboardActivity
    public static void startDashboardActivity(Context context) {
        Intent intent = new Intent(context, Dashboard_activity.class);
        context.startActivity(intent);
    }
}
