package vmaicon.banco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText evento, dataevento;

    private CompromissoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evento = (EditText) findViewById(R.id.editEvento);
        dataevento = (EditText) findViewById(R.id.editDataEvento);

        evento.setFocusable(true);

        dao = new CompromissoDAO(this);
        dao.abrir();
    }

    @Override
    protected void onPause() {
        //dao.fechar();
        super.onPause();
    }

    public void salvar(View view){
        Compromissos c = new Compromissos();
        c.setEvento(evento.getText().toString());
        c.setDataevento(dataevento.getText().toString());
        dao.inserir(c);//salva no banco

        Toast.makeText(this, "Novo evento adicionado: "+c.getEvento(), Toast.LENGTH_SHORT).show();

        evento.setText("");
        dataevento.setText("");
    }

    public void listarEventos(View view){
        Intent i = new Intent(this, ListCompromissos.class);
        startActivity(i);
    }
}
