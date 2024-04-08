package com.hasar.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hasar.agenda.db.DbContactos;

public class NuevoActivity extends AppCompatActivity {
    private EditText etNombre, etTelefono, etEmail;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        etNombre = findViewById(R.id.txtNombre);
        etTelefono = findViewById(R.id.editTextPhone);
        etEmail = findViewById(R.id.etEmail);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);
                long id = dbContactos.insertarContacto(etNombre.getText().toString(), etTelefono.getText().toString(), etEmail.getText().toString());

                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "Registro Guardado", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "Error al guardar Registro", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar() {
        etNombre.setText("");
        etTelefono.setText("");
        etEmail.setText("");
    }
}