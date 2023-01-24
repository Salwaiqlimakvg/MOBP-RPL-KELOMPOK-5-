package com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.adapter;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.CustomOnItemClickListener;
import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.NoteAddUpdateActivity;
import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.R;
import com.UTSmobproGenap.SalwaIqlimaKVG2000680.mycoffeshop.entity.CoffeeDrinkNote;

import java.util.ArrayList;


public class CoffeeDrinkNoteAdapter extends RecyclerView.Adapter<CoffeeDrinkNoteAdapter.NoteViewHolder> {
    private final ArrayList<CoffeeDrinkNote> listCoffeeDrinkNotes = new ArrayList<>();
    private final Activity activity;

    public CoffeeDrinkNoteAdapter(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<CoffeeDrinkNote> getListCoffeeDrinkNotes() {
        return listCoffeeDrinkNotes;
    }

    public void setListCoffeeDrinkNotes(ArrayList<CoffeeDrinkNote> listCoffeeDrinkNotes) {

        if (listCoffeeDrinkNotes.size() > 0) {
            this.listCoffeeDrinkNotes.clear();
        }
        this.listCoffeeDrinkNotes.addAll(listCoffeeDrinkNotes);

        notifyDataSetChanged();
    }

    public void addItem(CoffeeDrinkNote coffeeDrinkNote) {
        this.listCoffeeDrinkNotes.add(coffeeDrinkNote);
        notifyItemInserted(listCoffeeDrinkNotes.size() - 1);
    }

    public void updateItem(int position, CoffeeDrinkNote coffeeDrinkNote) {
        this.listCoffeeDrinkNotes.set(position, coffeeDrinkNote);
        notifyItemChanged(position, coffeeDrinkNote);
    }

    public void removeItem(int position) {
        this.listCoffeeDrinkNotes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listCoffeeDrinkNotes.size());
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        /* To Do Deklarasikan Textview Memasukan Nama ke View */
        holder.vNama.setText(listCoffeeDrinkNotes.get(position).getNama());
        holder.vKategori.setText(listCoffeeDrinkNotes.get(position).getKategori());
        holder.vDeskripsi.setText(listCoffeeDrinkNotes.get(position).getDeskripsi());
        holder.cvNote.setOnClickListener(new CustomOnItemClickListener(position, (view, position1) -> {
            Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
            intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position1);
            intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, listCoffeeDrinkNotes.get(position1));
            activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
        }));
    }

    @Override
    public int getItemCount() {
        return listCoffeeDrinkNotes.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        /* To Do Deklarasikan Texview Variabel */
        final TextView vNama, vKategori, vDeskripsi;
        final CardView cvNote;

        NoteViewHolder(View itemView) {
            super(itemView);
            /* To Do Deklarasikan View di Item Notes */
            cvNote = itemView.findViewById(R.id.cv_item_note);
            vNama = itemView.findViewById(R.id.tv_item_nama);
            vKategori = itemView.findViewById(R.id.tv_item_kategori);
            vDeskripsi = itemView.findViewById(R.id.tv_item_deskripsi);
        }
    }
}