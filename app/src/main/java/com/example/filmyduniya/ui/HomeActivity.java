package com.example.filmyduniya.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.filmyduniya.R;
import com.example.filmyduniya.adapters.MovieAdapter;
import com.example.filmyduniya.adapters.MovieItemClickListener;
import com.example.filmyduniya.adapters.SliderPagerAdapter;
import com.example.filmyduniya.models.Movie;
import com.example.filmyduniya.models.Slide;
import com.example.filmyduniya.utils.DataSource;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides ;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV,Action,Comedy,Drama,Horror,Mystory,Thriller ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iniViews();
        iniSlider();
        iniPopularMovies();
        iniAction();
        iniComedy();
        iniDrama();
        iniHorror();
        iniMystory();
        iniThriller();


    }



    private void iniPopularMovies() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Popular");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> lstMovies = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    lstMovies.add(new Movie(cover,desc,image,title,videos));
                }
                getMovie(lstMovies);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void getMovie(List<Movie> lstMovies) {
        MovieAdapter movieAdapter = new MovieAdapter(this, lstMovies,this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniAction() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Action");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> action = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    action.add(new Movie(cover,desc,image,title,videos));
                }
                getAction(action);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getAction(List<Movie> action){
        MovieAdapter Aaction = new MovieAdapter(this, action,this);
        Action.setAdapter(Aaction);
        Action.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }


    private void iniComedy() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Comedy");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> commedy = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    commedy.add(new Movie(cover,desc,image,title,videos));
                }
                getComedy(commedy);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getComedy(List<Movie> action){
        MovieAdapter Ccomedy = new MovieAdapter(this, action,this);
        Comedy.setAdapter(Ccomedy);
        Comedy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void iniDrama() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Drama");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> drama = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    drama.add(new Movie(cover,desc,image,title,videos));
                }
                getDrama(drama);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getDrama(List<Movie> action){
        MovieAdapter Ddrama = new MovieAdapter(this, action,this);
        Drama.setAdapter(Ddrama);
        Drama.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniHorror() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Horror");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> horror = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    horror.add(new Movie(cover,desc,image,title,videos));
                }
                getHorror(horror);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getHorror(List<Movie> action){
        MovieAdapter Hhorror = new MovieAdapter(this, action,this);
        Horror.setAdapter(Hhorror);
        Horror.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniMystory() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Mystry");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> mystry = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    mystry.add(new Movie(cover,desc,image,title,videos));
                }
                getMystory(mystry);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getMystory(List<Movie> action){
        MovieAdapter Mmystry = new MovieAdapter(this, action,this);
        Mystory.setAdapter(Mmystry);
        Mystory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniThriller() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Thriller");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Movie> thriller = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String cover=dataSnapshot.getValue(Movie.class).getCoverPhoto();
                    String desc=dataSnapshot.getValue(Movie.class).getDescription();
                    String title=dataSnapshot.getValue(Movie.class).getTitle();
                    String image=dataSnapshot.getValue(Movie.class).getThumbnail();
                    String videos=dataSnapshot.getValue(Movie.class).getStreamingLink();
                    thriller.add(new Movie(cover,desc,image,title,videos));
                }
                getThriller(thriller);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getThriller(List<Movie> action){
        MovieAdapter Tthriller = new MovieAdapter(this, action,this);
        Thriller.setAdapter(Tthriller);
        Thriller.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void iniSlider() {


        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Slider");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstSlides = new ArrayList<>() ;

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Slide slide=dataSnapshot.getValue(Slide.class);
                    lstSlides.add(slide);
                }
                SliderPagerAdapter adapter = new SliderPagerAdapter(getApplicationContext(),lstSlides);
                sliderpager.setAdapter(adapter);
                // setup timer
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new SliderTimer(),40000,60000);
                indicator.setupWithViewPager(sliderpager,true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager) ;
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);
        Action=findViewById(R.id.Action);
        Drama=findViewById(R.id.Drama);
        Comedy=findViewById(R.id.Comedy);
        Horror=findViewById(R.id.Horror);
        Mystory=findViewById(R.id.Mystry);
        Thriller=findViewById(R.id.Thriller);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // here we send movie information to detail activity
        // also we ll create the transition animation between the two activity

        Intent intent = new Intent(this,MovieDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());
        intent.putExtra("description",movie.getDescription());
        intent.putExtra("videourl",movie.getStreamingLink());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());



        // i l make a simple test to see if the click works

        Toast.makeText(this,"item clicked : " + movie.getTitle(),Toast.LENGTH_LONG).show();
        // it works great


    }

    class SliderTimer extends TimerTask {


        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }
}
