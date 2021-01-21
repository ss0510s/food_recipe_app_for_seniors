package com.example.project2;

public class ItemList {
    private String main_text;//각 아이템 뷰에 들어갈 변수
    private int main_image;

    public ItemList(int main_image, String main_text) {
        this.main_image = main_image;
        this.main_text = main_text;
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

}
