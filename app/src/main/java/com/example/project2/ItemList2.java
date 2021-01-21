package com.example.project2;

public class ItemList2 {
    private String main_text;//각 아이템 뷰에 들어갈 변수
    private String year;
    private String explain;
    private int main_image;
    private int blog;
    private int youtube;

    public ItemList2(int main_image, String main_text, String year, String explain, int blog, int youtube) {
        this.main_image = main_image;
        this.main_text = main_text;
        this.year = year;
        this.explain = explain;
        this.blog = blog;
        this.youtube = youtube;
    }

    public int getImage() {
        return main_image;
    }

    public void setImage(int main_image) {
        this.main_image = main_image;
    }

    public String getText() {
        return main_text;
    }

    public void setText(String main_text) {
        this.main_text = main_text;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String main_text) {
        this.main_text = main_text;
    }

    public int getBlog() {
        return blog;
    }

    public void setBlog(int blog) {
        this.blog = blog;
    }

    public int getYoutube() {
        return youtube;
    }

    public void setYoutube(int youtube) {
        this.youtube = youtube;
    }

}