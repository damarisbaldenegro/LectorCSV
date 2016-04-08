package com.example.usuario.csvlector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class GuardarDatos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_datos);


        TextView txtRes = (TextView) findViewById(R.id.tv);
        Intent act = getIntent();
        String s = getIntent().getStringExtra("TextValue1");
        txtRes.setText(s);









    }


}
