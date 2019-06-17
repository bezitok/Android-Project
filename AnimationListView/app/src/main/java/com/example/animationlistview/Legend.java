package com.example.animationlistview;

public class Legend {
    String name;
    String club;
    int image;

    public Legend() {
    }

    public Legend(String name, String club, int image) {
        this.name = name;
        this.club = club;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
