package com.example.usuario.csvlector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnVer = (Button) findViewById(R.id.buttonVer);
        btnVer.setOnClickListener(this);
        Button btnGuardar = (Button) findViewById(R.id.buttonGuardar);
        btnGuardar.setOnClickListener(this);

    }

    public void onClick(View v) {
        EditText Nombre = (EditText) findViewById(R.id.EditTextNom);
        EditText ApellidoPaterno = (EditText) findViewById(R.id.EditextAP);
        EditText ApellidoMaterno = (EditText) findViewById(R.id.EditextAM);
        EditText code = (EditText) findViewById(R.id.EditTextCod);

        TextView tv = (TextView) findViewById(R.id.textView6);


        if (v.getId() == R.id.buttonGuardar) {
            String nombre = Nombre.getText().toString();
            String apellidop = ApellidoPaterno.getText().toString();
            String apellidom = ApellidoMaterno.getText().toString();
            String codigo = code.getText().toString();

            if (nombre.isEmpty() && apellidop.isEmpty() && apellidom.isEmpty() && codigo.isEmpty()) {
                Nombre.setError("Ingresa un Nombre");
                ApellidoPaterno.setError("Ingresa un Apellido Paterno");
                ApellidoMaterno.setError("Ingresa un Apellido Materno");
                code.setError("Ingresa un codigo");
                return;
            } else {
                FileOutputStream fout = null;
                try {
                    fout = openFileOutput("datos4.txt", MODE_APPEND);
                    OutputStreamWriter ows = new OutputStreamWriter(fout);
                    String texto = nombre + "," + apellidop + "," + apellidom + "," + codigo + "\r\n";
                    ows.write(texto);
                    ows.flush(); //Volca lo que hay en el buffer al archivo
                    ows.close(); //Cierra el archivo de texto

                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getBaseContext(), "El archivo se ha almacenado!!!", Toast.LENGTH_SHORT).show();

                Nombre.setText("");
                ApellidoPaterno.setText("");
                ApellidoMaterno.setText("");
                code.setText("");
            }
        }
            if (v.getId() == R.id.buttonVer) {
                try {

                    BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("datos4.txt")));

                    String line, linea = "";

                    while ((line = fin.readLine()) != null)
                        linea += line + "\r\n";

                    Intent act = new Intent(this, GuardarDatos.class);
                    act.putExtra("TextValue1", linea);
                    startActivity(act);


                    fin.close();

                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al leer fichero desde memoria interna");
                }

            }
    }
}





