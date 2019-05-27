package com.firyalfauzi.submissionfoodbismillah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    String[] empasi, detailempasi;
    int[] gambarempasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        rv = findViewById( R.id.rv );

        empasi = getResources().getStringArray( R.array.empasi );
        detailempasi = getResources().getStringArray( R.array.manfaat );
        gambarempasi = new int[]{
                R.drawable.alpukat,
                R.drawable.bayam,
                R.drawable.jagung,
                R.drawable.kentang,
                R.drawable.naga,
                R.drawable.pir,
                R.drawable.pisang,
                R.drawable.wortel
        };

        AdapterFood adapter = new AdapterFood( MainActivity.this , gambarempasi, empasi, detailempasi );
        rv.setHasFixedSize( true );
        rv.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
        rv.setAdapter( adapter );
    }
}
