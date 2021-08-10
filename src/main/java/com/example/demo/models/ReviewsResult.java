package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

public class ReviewsResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Review> reviews;
    private int total;
    private String[] possible_languages;

    public ReviewsResult() {
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String[] getPossible_languages() {
        return possible_languages;
    }

    public void setPossible_languages(String[] possible_languages) {
        this.possible_languages = possible_languages;
    }
}
