package com.example.lab3rel;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    private Button btn;

    public Dialog onCreateDialog(Bundle state){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        super.onCreateDialog(state);
        return builder.setTitle("Cправка")
                      .setView(R.layout.dialog)
                      .setPositiveButton("Закрыть", null)
                      .create();
    }
}
