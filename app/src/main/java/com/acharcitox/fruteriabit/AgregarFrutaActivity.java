package com.acharcitox.fruteriabit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgregarFrutaActivity extends AppCompatActivity {
    public static final String EXTRA_MSG_ID = "com.acharcitox.fruteriabit.MSG_GUARDAR_ID";
    public static final String EXTRA_MSG_NOMBRE = "com.acharcitox.fruteriabit.MSG_GUARDAR_NOMBRE";
    public static final String EXTRA_MSG_DESCRIPCION = "com.acharcitox.fruteriabit.MSG_GUARDAR_DESCRIPCION";


    private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_fruta);

        editTextNombre = findViewById(R.id.textViewIngresarNombre);

        final Button btnAgregar = findViewById(R.id.btnGuardar);
        btnAgregar.setOnClickListener(view -> {
            Intent respueta = new Intent();
            if (TextUtils.isEmpty(editTextNombre.getText())) {
                setResult(RESULT_CANCELED, respueta);
            } else {
                String fruta = editTextNombre.getText().toString();
                respueta.putExtra(EXTRA_MSG_NOMBRE, fruta);
                setResult(RESULT_OK, respueta);
            }
            finish();
        });
    }
}