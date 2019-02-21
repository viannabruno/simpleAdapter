package com.example.aluno.simpleadapter;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.aluno.simpleadapter.entidades.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleAdapterActivity extends AppCompatActivity {

    public EditText txtId;
    public EditText txtData;
    public EditText txtValor;
    public EditText txtCliente;
    public List<Pedido> lista = new ArrayList<>();
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
    }

    public void adicionar(View view) {

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

        String dados = String.format("Os dados sao: \n %s \n %s \n %s \n %s", id, cliente,data, valor );

        Toast.makeText(this,dados, Toast.LENGTH_SHORT).show();


        Pedido pedido = new Pedido(id, cliente, data, valor);

        lista.add(pedido);


        List<String> lista02 = new ArrayList<>();

        List<HashMap<String, String>> listaHash = new ArrayList<>();


        for (Pedido p : lista) {
            HashMap<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(p.getId()));
            map.put("cliente", p.getCliente());
            map.put("data", p.getData());
            map.put("valor", String.valueOf(p.getValor()));

            listaHash.add(map);
            lista02.add(String.valueOf(p.getId()));
        }

        String[] from = {"id", "cliente", "data", "valor"};
        int[] to = {R.id.txtId, R.id.txtCliente, R.id.txtData, R.id.txtValor};



        listView = findViewById(R.id.listView);


        SimpleAdapter adapter =
                new SimpleAdapter(this,listaHash,
                        R.layout.item,from,to);


        listView.setAdapter(adapter);
    }
}
