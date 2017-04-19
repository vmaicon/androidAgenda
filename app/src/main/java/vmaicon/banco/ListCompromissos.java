package vmaicon.banco;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by maicon on 19/04/2017.
 */

public class ListCompromissos extends ListActivity {
    private List<Compromissos> list;
    private ArrayAdapter arrayAdapter;
    private CompromissoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        dao = new CompromissoDAO(this);
        dao.abrir();

        list = dao.list();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(arrayAdapter);

        //Log.i("item", list.toString());
    }

    @Override
    protected void onPause() {
        dao.fechar();
        super.onPause();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Compromissos c = (Compromissos) l.getItemAtPosition(position);

        Toast.makeText(this, "clicado: "+c.getEvento(), Toast.LENGTH_SHORT).show();
    }
}

