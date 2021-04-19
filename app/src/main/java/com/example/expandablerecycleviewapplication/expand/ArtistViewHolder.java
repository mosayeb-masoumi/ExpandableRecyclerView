package com.example.expandablerecycleviewapplication.expand;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expandablerecycleviewapplication.R;
import com.example.expandablerecycleviewapplication.model.Artist;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ArtistViewHolder extends ChildViewHolder {

    private TextView childTextView;
    private RelativeLayout root_child;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        childTextView = itemView.findViewById(R.id.list_item_artist_name);
        root_child = itemView.findViewById(R.id.root_child);



    }

    public void setArtistName(Artist artist) {
        childTextView.setText(artist.getName());

    }

    public void setOnArtistHolderListener(Artist artist) {

        root_child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), ""+artist.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
