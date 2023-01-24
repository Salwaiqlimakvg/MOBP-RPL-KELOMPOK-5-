package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract.NoteColumns.TABLE_NAME;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbcoffeedrinknote";

    private static final int DATABASE_VERSION = 1;

    /* To Do Lengkapi Struktur Kode Create SQLnya */
    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL," +
            " %s TEXT NOT NULL)",
    TABLE_NAME,
    DatabaseContract.NoteColumns._ID,
    DatabaseContract.NoteColumns.NAMA,
    DatabaseContract.NoteColumns.DESKRIPSI,
    DatabaseContract.NoteColumns.KATEGORI,
    DatabaseContract.NoteColumns.MAKANAN_PELENGKAP
    );

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    /*
    Method onUpgrade akan di panggil ketika terjadi perbedaan versi
    Gunakan method onUpgrade untuk melakukan proses migrasi data
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        Drop table tidak dianjurkan ketika proses migrasi terjadi dikarenakan data user akan hilang,
        */
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
