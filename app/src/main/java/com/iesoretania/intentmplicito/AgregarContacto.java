package com.iesoretania.intentmplicito;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.iesoretania.intentmplicito.databinding.ActivityAgregarContactoBinding;

public class AgregarContacto extends AppCompatActivity {

    private ActivityAgregarContactoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agregar_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityAgregarContactoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.editTextText2.getText().toString();
                String Telefono = binding.editTextText3.getText().toString();
                String gmail = binding.editTextText4.getText().toString();
                listaContactos(nombre, Telefono, gmail);

            }
        });
    }

    private void listaContactos(String nombre, String Telefono, String gmail) {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        intent.putExtra(ContactsContract.Intents.Insert.NAME, nombre);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, Telefono);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, gmail);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}