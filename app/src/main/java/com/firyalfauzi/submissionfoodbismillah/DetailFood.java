package com.firyalfauzi.submissionfoodbismillah;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailFood extends Activity {
    ImageView img;
    TextView judul, detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_food );

        img = findViewById( R.id.img2 );
        judul = findViewById( R.id.judul2 );
        detail = findViewById( R.id.manfaat );

        judul.setText( getIntent().getStringExtra( "empasi" ) );
        detail.setText( getIntent().getStringExtra( "detailempasi" ) );
        Glide.with( this ).load( getIntent().getIntExtra( "gambarempasi", 0 ) ).into( img );

    }
}
