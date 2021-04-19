package com.example.expandablerecycleviewapplication.expand;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandablerecycleviewapplication.R;
import com.example.expandablerecycleviewapplication.model.Genre;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class GenreViewHolder extends GroupViewHolder {
//public class GenreViewHolder extends RecyclerView.ViewHolder{

    private TextView genreName;
    private ImageView arrow;
    private ImageView icon;

    FrameLayout root;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreName =  itemView.findViewById(R.id.list_item_genre_name);
        arrow = itemView.findViewById(R.id.list_item_genre_arrow);
        icon = itemView.findViewById(R.id.list_item_genre_icon);

        root = itemView.findViewById(R.id.root);
//        root.setClickable(false);
//        expand();
    }

    public void setGenreTitle(ExpandableGroup genre) {
        if (genre instanceof Genre) {
//            genreName.setText(genre.getTitle());

            genreName.setText(((Genre) genre).getTtitle());
            icon.setBackgroundResource(((Genre) genre).getIconResId());


        }

    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
