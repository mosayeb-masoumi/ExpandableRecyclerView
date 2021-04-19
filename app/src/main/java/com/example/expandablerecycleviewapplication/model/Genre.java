package com.example.expandablerecycleviewapplication.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Genre extends ExpandableGroup<Artist> {

    private int iconResId;
    private String ttitle;

    public Genre(String title, List<Artist> items, int iconResId) {
        super(title, items);
        this.iconResId = iconResId;
        this.ttitle = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTtitle() {
        return ttitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

//        return getIconResId() == genre.getIconResId();
        return genre == genre;

    }

    @Override
    public int hashCode() {
        return getIconResId();
    }
}
