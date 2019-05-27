package com.firyalfauzi.submissionfoodbismillah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.ViewHolder> {
    Context context;
    int[] gambarEmpasi;
    String[] judul, detailEmpasi;

    public AdapterFood(Context context, int[] gambarEmpasi, String[] judul, String[] detailEmpasi) {
        this.context = context;
        this.gambarEmpasi = gambarEmpasi;
        this.judul = judul;
        this.detailEmpasi = detailEmpasi;
    }

    @NonNull
    @Override
    public AdapterFood.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.lisritem_food, viewGroup, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFood.ViewHolder viewHolder, final int i) {
        viewHolder.txt.setText( judul[i] );
        Glide.with( context )
                .load( gambarEmpasi[i] )
                .into( viewHolder.img );

        viewHolder.cv.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent( context, DetailFood.class );
                move.putExtra( "empasi", judul[i] );
                move.putExtra( "gambarempasi", gambarEmpasi[i] );
                move.putExtra( "detailempasi" , detailEmpasi[i]);
                context.startActivity( move );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return gambarEmpasi.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt;
        CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            img = itemView.findViewById( R.id.img );
            txt = itemView.findViewById( R.id.judul );
            cv = itemView.findViewById( R.id.cv );
        }
    }
}
