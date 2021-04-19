package com.example.expandablerecycleviewapplication.expand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.expandablerecycleviewapplication.R;
import com.example.expandablerecycleviewapplication.model.Genre;

import java.util.List;

import static com.example.expandablerecycleviewapplication.util.GenreDataFactory.makeClassicGenre;
import static com.example.expandablerecycleviewapplication.util.GenreDataFactory.makeGenres;

public class ExpandActivity extends AppCompatActivity {

    public GenreAdapter adapter;

//    https://github.com/thoughtbot/expandable-recycler-view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);

        RecyclerView recyclerView =  findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }


        List<Genre> list = makeGenres();

        adapter = new GenreAdapter(list);
        recyclerView.setLayoutManager(layoutManager);


// this for make all father items expandable . if we wanna lock expanding we should do  root.setClickable(false); for each items of father
//        for (int i = list.size() - 1; i >= 0; i--) {
//            adapter.toggleGroup(i);
//        }

        recyclerView.setAdapter(adapter);

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}