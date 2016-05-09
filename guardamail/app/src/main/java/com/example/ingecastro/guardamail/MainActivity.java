package com.example.ingecastro.guardamail;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etxt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxt=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
        SharedPreferences pref=getSharedPreferences("datos", Context.MODE_PRIVATE);
        etxt.setText(pref.getString("mail",""));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("mail", etxt.getText().toString());
                editor.commit();
                finish();

            }
        });


    }
}
