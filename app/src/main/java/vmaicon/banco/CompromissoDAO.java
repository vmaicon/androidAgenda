package vmaicon.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maicon on 19/04/2017.
 */

public class CompromissoDAO {

    private SQLiteDatabase db;
    private  BancoOpenHelper openHelper;

    public CompromissoDAO(Context context){
        openHelper = new BancoOpenHelper(context);
    }

    public void abrir(){db = openHelper.getWritableDatabase();}
    public void fechar(){db.close();}

    //para inserir
    public Compromissos inserir(Compromissos compromissos){
        ContentValues values = new ContentValues();

        values.put("evento", compromissos.getEvento());
        values.put("dataevento", compromissos.getDataevento());

        Compromissos comp;
        comp = compromissos;
        comp.setId(db.insert("compromissos", null, values));
        return comp;
    }
    //listagem
    public List<Compromissos> list(){
        List<Compromissos> list = new ArrayList<>();
        Cursor cursor = db.query("compromissos", null, null, null, null, null, "dataevento DESC");
        while(cursor.moveToNext()){
            Compromissos c = new Compromissos();
            c.setId(cursor.getInt(0));
            c.setEvento(cursor.getString(1));
            c.setDataevento(cursor.getString(2));

            list.add(c);
        }
            return list;
    }
}
