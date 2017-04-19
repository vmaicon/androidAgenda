package vmaicon.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maicon on 19/04/2017.
 */

public class BancoOpenHelper extends SQLiteOpenHelper {

    public BancoOpenHelper(Context context) {
        super(context, "agenda.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbmcompras = "CREATE TABLE compromissos (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "evento TEXT, " +
                "dataevento TEXT);";


        db.execSQL(tbmcompras);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS compromissos");

        onCreate(db);
    }
}
