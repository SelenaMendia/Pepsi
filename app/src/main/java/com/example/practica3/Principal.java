package com.example.practica3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;
import android.media.MediaPlayer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Principal extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, R.string.inicio, Toast.LENGTH_SHORT).show();
    }
    VideoView idVideoView;

    Button btnVolverInicio, btnAcerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnVolverInicio = findViewById(R.id.btnVolverInicio);
        btnAcerca = findViewById(R.id.btnAcerca);

        idVideoView = findViewById(R.id.idVideoView);


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pepsi;

        idVideoView.setVideoURI(Uri.parse(videoPath));
        idVideoView.start();

        idVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                idVideoView.start();
            }
        });


        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Login.class);
                startActivity(intent);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Acerca_de.class);
                startActivity(intent);
            }
        });




    }


    }
