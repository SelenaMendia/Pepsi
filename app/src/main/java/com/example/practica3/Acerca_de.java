package com.example.practica3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.content.Intent;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;


import android.net.Uri;
import android.widget.Toast;
import android.view.View;
import android.content.pm.PackageManager;


public class Acerca_de extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, R.string.acerca_de_desarrollador, Toast.LENGTH_SHORT).show();
    }
    Button btnVolverPrincipal, btnMarcar, btnCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca_de);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnVolverPrincipal = findViewById(R.id.btnVolverPrincipal);
        btnMarcar = findViewById(R.id.btnMarcar);
        btnCorreo = findViewById(R.id.btnCorreo);


        btnVolverPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Principal.class);
                startActivity(intent);
            }
        });
    }

    public void marcarNumero(View view) {
        String numero = "2954222653";
        Uri uri = Uri.parse("tel:" + numero);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void enviarCorreoConGmail(View view) {
        String destinatario = "selenamendia1@gmail.com";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + destinatario));

        PackageManager packageManager = getPackageManager();
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No se encontró ninguna aplicación de correo electrónico", Toast.LENGTH_SHORT).show();
        }
    }


}