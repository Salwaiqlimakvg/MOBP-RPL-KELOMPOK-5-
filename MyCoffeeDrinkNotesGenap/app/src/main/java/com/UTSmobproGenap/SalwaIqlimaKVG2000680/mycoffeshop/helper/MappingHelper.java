package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.helper;

import android.database.Cursor;

import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract;
import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.entity.CoffeeDrinkNote;

import java.util.ArrayList;

public class MappingHelper {

    public static ArrayList<CoffeeDrinkNote> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<CoffeeDrinkNote> notesList = new ArrayList<>();

        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID));
            String nama = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.NAMA));
            String deskripsi = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESKRIPSI));
            String kategori = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.KATEGORI));
            String makanan_pelengkap = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.MAKANAN_PELENGKAP));
            notesList.add(new CoffeeDrinkNote(id, nama, deskripsi, kategori, makanan_pelengkap));
        }

        return notesList;
    }
}
