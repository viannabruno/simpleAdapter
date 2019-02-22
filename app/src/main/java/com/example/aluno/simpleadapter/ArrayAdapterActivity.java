package com.example.aluno.simpleadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.aluno.simpleadapter.entidades.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterActivity extends AppCompatActivity {

    public EditText txtId;
    public EditText txtData;
    public EditText txtValor;
    public EditText txtCliente;
    public List<Pedido> lista = new ArrayList<>();
    public ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
    }

    public void adicionar(View view) {

        //ENTRADA DE DADOS
        //Captura o componente EditText da VIEW
        txtId = findViewById(R.id.txtId);
        txtData = findViewById(R.id.txtData);
        txtValor = findViewById(R.id.txtValor);
        txtCliente = findViewById(R.id.txtCliente);

        long id;
        BigDecimal valor;
        String data, cliente;

        id = Long.parseLong(txtId.getText().toString());
        cliente = txtCliente.getText().toString();
        data = txtData.getText().toString();
        valor = BigDecimal.valueOf(Long.parseLong(txtValor.getText().toString()));

        Pedido pedido = new Pedido(id, cliente, data, valor);

        lista.add(pedido);

        //SAIDA

        listView = findViewById(R.id.listView);

        //ARRAY ADAPTER
        ArrayAdapter<Pedido> arrayAdapter =
                new ArrayAdapter<Pedido>(this,
                        android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);
    }



}
