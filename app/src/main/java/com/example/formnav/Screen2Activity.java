package com.example.formnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        // Récupérer les données envoyées depuis MainActivity
        String nom     = getIntent().getStringExtra("nom");
        String email   = getIntent().getStringExtra("email");
        String phone   = getIntent().getStringExtra("phone");
        String adresse = getIntent().getStringExtra("adresse");
        String ville   = getIntent().getStringExtra("ville");

        // Construire le texte récapitulatif
        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nPhone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);

        recap.setText(resume);

        // Bouton retour → fermer l'écran
        btnRetour.setOnClickListener(v -> finish());
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
