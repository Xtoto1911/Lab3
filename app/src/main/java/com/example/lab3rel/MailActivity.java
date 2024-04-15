package com.example.lab3rel;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import android.widget.Toast;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MailActivity extends Activity{
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mail);
            textView1 = (TextView) findViewById(R.id.a1);
            textView2 = (TextView) findViewById(R.id.d);
            textView3 = (TextView) findViewById(R.id.n);
            textView4 = (TextView) findViewById(R.id.an);
            textView5 = (TextView) findViewById(R.id.Sn);
            backBtn = (Button) findViewById(R.id.b2);
            String a1St = getIntent().getStringExtra("a1");
            String dSt = getIntent().getStringExtra("d");
            String nSt = getIntent().getStringExtra("n");
            textView1.setText(a1St);
            textView2.setText(dSt);
            textView3.setText(nSt);
            Double a1 = Double.parseDouble(a1St);
            Double d = Double.parseDouble(dSt);
            Double n = Double.parseDouble(nSt);
            Double an = a1 + d * (n - 1);
            Double Sn = (a1 + an) * n / 2;
            textView4.setText(an.toString());
            textView5.setText(Sn.toString());
            Button sent = (Button) findViewById(R.id.sendEmail);
            sent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sentEmail();
                }
            });
        }catch (Exception e){

        }
    }

    public void back(View view){
        Intent intent = new Intent(MailActivity.this, MainActivity.class);
        startActivity(intent);
    }

    protected void sentEmail(){
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.label));
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                (
                    ((TextView) findViewById(R.id.t1)).getText().toString() + ": " + textView1.getText().toString()+"\n"+
                    ((TextView) findViewById(R.id.t2)).getText().toString() + ": " + textView2.getText().toString()+"\n"+
                    ((TextView) findViewById(R.id.t3)).getText().toString() + ": " + textView3.getText().toString()+"\n"+
                    ((TextView) findViewById(R.id.t4)).getText().toString() + ": " + textView4.getText().toString()+"\n"+
                    ((TextView) findViewById(R.id.t5)).getText().toString() + ": " + textView5.getText().toString()+"\n"
                ));

        try {
            startActivity(Intent.createChooser(emailIntent, "Отправить..."));
            finish();
            Log.i("Заканчиваем отправку сообщения...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MailActivity.this, "Не установлен почтовый клиент.", Toast.LENGTH_SHORT).show();
        }
    }
}
