package ControlWork4;

import java.util.List;

public class Cats {
    private List<Cat> cats;

    public Cats(List<Cat> cats) {
        this.cats = cats;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
