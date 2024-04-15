package com.example.lab3rel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kotlin.UInt;

public class MainActivity extends AppCompatActivity {

    private EditText a1;
    private EditText d;
    private EditText n;
    private Button goRes;

    private boolean isNotEmptyEdit(String a1, String d, String n){
        if(
            TextUtils.isEmpty(a1) ||
            TextUtils.isEmpty(d) ||
            TextUtils.isEmpty(n)
        ){
            return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1 = (EditText)findViewById(R.id.a1);
        d = (EditText)findViewById(R.id.d);
        n = (EditText)findViewById(R.id.n);
        goRes = (Button) findViewById(R.id.sendEmail);
    }

    public void Send(View view){
        String inputA1 = a1.getText().toString();
        String inputD = d.getText().toString();
        String inputN = n.getText().toString();
        Intent intent = new Intent(MainActivity.this, MailActivity.class);
        Toast noNotes = Toast.makeText(this, R.string.noNotes,Toast.LENGTH_LONG);
        Toast inputEx = Toast.makeText(this, R.string.inputEx,Toast.LENGTH_LONG);
        if(isNotEmptyEdit(inputA1,inputD,inputN)){
            try{
                Double firstProgr = Double.parseDouble(inputA1);
                Double diff = Double.parseDouble(inputD);
                Double number = Double.parseDouble(inputN);
                if(number <= 0)
                    throw new Exception();

                intent.putExtra("a1", firstProgr.toString());
                intent.putExtra("d", diff.toString());
                intent.putExtra("n", number.toString());
                startActivity(intent);
            }catch (Exception e){
                inputEx.show();
                System.out.println(e.getMessage().toString());
            }
        }
        else {
            noNotes.show();
        }
    }

    public void showDialog(View view){
        MyDialog dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(),"custom");
    }
}