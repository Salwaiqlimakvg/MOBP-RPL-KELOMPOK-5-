package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final class NoteColumns implements BaseColumns {
        public static final String TABLE_NAME = "coffeedrinknote";

        //Coffee Drink Note Nama
        public static final String NAMA = "nama";
        //Coffee Drink Note Deskripsi
        public static final String DESKRIPSI = "deskripsi";
        //Coffee Drink Note Kategori
        public static final String KATEGORI = "kategori";
        //Coffee Drink Note Ukuran
        public static final String MAKANAN_PELENGKAP = "makanan_pelengkap";

    }
}
