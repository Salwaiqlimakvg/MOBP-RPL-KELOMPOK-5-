package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.CoffeeDrinkNoteHelper;
import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.entity.CoffeeDrinkNote;
//import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.R;

import static com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract.NoteColumns.NAMA;
import static com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract.NoteColumns.KATEGORI;
import static com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract.NoteColumns.DESKRIPSI;
import static com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.db.DatabaseContract.NoteColumns.MAKANAN_PELENGKAP;

public class NoteAddUpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNama, edtDeskripsi;
    private Spinner spnrKategori;
    private CheckBox chCake, chBrownies, chDalgonaCandy;
    private String makananPelengkap1, makananPelengkap2, makananPelengkap3;

    private boolean isEdit = false;
    private CoffeeDrinkNote coffeeDrinkNote;
    private int position;
    private CoffeeDrinkNoteHelper coffeeDrinkNoteHelper;

    public static final String EXTRA_NOTE = "extra_note";
    public static final String EXTRA_POSITION = "extra_position";
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;
    public static final int REQUEST_UPDATE = 200;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    private final int ALERT_DIALOG_CLOSE = 10;
    private final int ALERT_DIALOG_DELETE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add_update);

        /* To Do Lengkapi Dari Atribut di Atas Identifikasi Komponen Viewnya */
        edtNama = findViewById(R.id.edt_nama);
        edtDeskripsi = findViewById(R.id.edt_deskripsi);
        spnrKategori = findViewById(R.id.spnr_kategori);
        chCake= findViewById(R.id.ch_cake);
        chBrownies= findViewById(R.id.ch_brownies);
        chDalgonaCandy = findViewById(R.id.ch_dalgonacandy);

        Button btnSubmit = findViewById(R.id.btn_submit);

        coffeeDrinkNoteHelper = CoffeeDrinkNoteHelper.getInstance(getApplicationContext());
        coffeeDrinkNoteHelper.open();

        coffeeDrinkNote = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (coffeeDrinkNote != null) {
            position = getIntent().getIntExtra(EXTRA_POSITION, 0);
            isEdit = true;
        } else {
            coffeeDrinkNote = new CoffeeDrinkNote();
        }

        String actionBarTitle;
        String btnTitle;

        if (isEdit) {
            actionBarTitle = "Ubah";
            btnTitle = "Update";

            if (coffeeDrinkNote != null) {
                /* To Do Lengkapi Kode Disini Untuk Ketika Menampilkan Data Edit */
                edtNama.setText(coffeeDrinkNote.getNama());
                edtDeskripsi.setText(coffeeDrinkNote.getDeskripsi());
                String category = coffeeDrinkNote.getKategori();
                if(category.equals("Kopi Arabika")){
                    spnrKategori.setSelection(0);
                }

                if(category.equals("Kopi Robusta")){
                    spnrKategori.setSelection(1);
                }

                if(category.equals("Kopi Liberika")){
                    spnrKategori.setSelection(2);
                }

                if(category.equals("Kopi Ekselsa")){
                    spnrKategori.setSelection(3);
                }

                if (coffeeDrinkNote.getMakananPelengkap().contains("Cake")){
                    chCake.setChecked(true);
                } else if (!coffeeDrinkNote.getMakananPelengkap().contains("Cake")){
                    chCake.setChecked(false);
                }

                if (coffeeDrinkNote.getMakananPelengkap().contains("Brownies")){
                    chBrownies.setChecked(true);
                } else if (!coffeeDrinkNote.getMakananPelengkap().contains("Brownies")){
                    chBrownies.setChecked(false);
                }

                if (coffeeDrinkNote.getMakananPelengkap().contains("Dalgona Candy")){
                    chDalgonaCandy.setChecked(true);
                } else if (!coffeeDrinkNote.getMakananPelengkap().contains("Dalgona Candy")){
                    chDalgonaCandy.setChecked(false);
                }
            }

        } else {
            actionBarTitle = "Tambah";
            btnTitle = "Simpan";
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSubmit.setText(btnTitle);

        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_submit) {
            String nama = edtNama.getText().toString().trim();
            String deskripsi = edtDeskripsi.getText().toString().trim();
            String kategori = spnrKategori.getSelectedItem().toString().trim();

            /* To Do Ubah Variabel ini untuk dibawah */
            String makananPelengkap;

            if (chCake.isChecked()) {
                makananPelengkap1 = "Cake";
            } else if (!chCake.isChecked()) {
                makananPelengkap1 = "";
            }

            if (chBrownies.isChecked()) {
                makananPelengkap2 = "Brownies";
            } else if (!chBrownies.isChecked()) {
                makananPelengkap2 = "";
            }

            if (chDalgonaCandy.isChecked()) {
                makananPelengkap3 = "Dalgona Candy";
            } else if (!chDalgonaCandy.isChecked()) {
                makananPelengkap3 = "";
            }

            makananPelengkap = makananPelengkap1 + makananPelengkap2 + makananPelengkap3;

            /*
            Jika fieldnya masih kosong maka tampilkan error
             */
            if (TextUtils.isEmpty(nama)) {
                edtNama.setError("Field can not be blank");
                return;
            }

            /* To Do Lengkapi Kode Disini Input ke DB MySQLite */
            coffeeDrinkNote.setNama(nama);
            coffeeDrinkNote.setDeskripsi(deskripsi);
            coffeeDrinkNote.setKategori(kategori);
            coffeeDrinkNote.setMakananPelengkap(makananPelengkap);

            Intent intent = new Intent();
            intent.putExtra(EXTRA_NOTE, coffeeDrinkNote);
            intent.putExtra(EXTRA_POSITION, position);

            //Gunakan contentvalues untuk menampung data
            ContentValues values = new ContentValues();
            values.put(NAMA, nama);
            values.put(DESKRIPSI, deskripsi);
            values.put(KATEGORI, kategori);
            values.put(MAKANAN_PELENGKAP, makananPelengkap);

            /*
            Jika merupakan edit maka setresultnya UPDATE, dan jika bukan maka setresultnya ADD
            */
            if (isEdit) {
                long result = coffeeDrinkNoteHelper.update(String.valueOf(coffeeDrinkNote.getId()), values);
                if (result > 0) {
                    setResult(RESULT_UPDATE, intent);
                    finish();
                } else {
                    Toast.makeText(NoteAddUpdateActivity.this, "Gagal mengupdate data", Toast.LENGTH_SHORT).show();
                }
            } else {
                long result = coffeeDrinkNoteHelper.insert(values);

                if (result > 0) {
                    coffeeDrinkNote.setId((int) result);
                    setResult(RESULT_ADD, intent);
                    finish();
                } else {
                    Toast.makeText(NoteAddUpdateActivity.this, "Gagal menambah data", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isEdit) {
            getMenuInflater().inflate(R.menu.menu_form, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_delete) {
            showAlertDialog(ALERT_DIALOG_DELETE);
        } else if (id == android.R.id.home) {
            showAlertDialog(ALERT_DIALOG_CLOSE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    /*
    Konfirmasi dialog sebelum proses batal atau hapus
    close = 10
    deleteNote = 20
     */
    private void showAlertDialog(int type) {
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogTitle, dialogMessage;

        if (isDialogClose) {
            dialogTitle = "Batal";
            dialogMessage = "Apakah anda ingin membatalkan perubahan pada form?";
        } else {
            dialogMessage = "Apakah anda yakin ingin menghapus item ini?";
            dialogTitle = "Hapus Note";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder
                .setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Ya", (dialog, id) -> {
                    if (isDialogClose) {
                        finish();
                    } else {
                        long result = coffeeDrinkNoteHelper.deleteById(String.valueOf(coffeeDrinkNote.getId()));
                        if (result > 0) {
                            Intent intent = new Intent();
                            intent.putExtra(EXTRA_POSITION, position);
                            setResult(RESULT_DELETE, intent);
                            finish();
                        } else {
                            Toast.makeText(NoteAddUpdateActivity.this, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Tidak", (dialog, id) -> dialog.cancel());
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
