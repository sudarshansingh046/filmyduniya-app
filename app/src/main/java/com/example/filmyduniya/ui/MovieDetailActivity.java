package com.example.filmyduniya.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.filmyduniya.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private FloatingActionButton play_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        // ini views
        iniViews();
    }

    void iniViews() {
        play_fab = findViewById(R.id.play_fab);
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_description = findViewById(R.id.detail_movie_desc);
        String movieTitle = getIntent().getExtras().getString("title");
        String imageResourceId=getIntent().getExtras().getString("imgURL");
        String coverpic=getIntent().getExtras().getString("imgCover");
        String description=getIntent().getExtras().getString("description");
        String videourl=getIntent().getExtras().getString("videourl");
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        Glide.with(this).load(coverpic).into(MovieCoverImg);
        tv_title.setText(movieTitle);
        tv_description.setText(description);
        play_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MoviePlayerActivity.class);
                i.putExtra("videourl",videourl);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        getSupportActionBar().setTitle(movieTitle);
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));





    }


}
