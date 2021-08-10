package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

public class BusinessResults implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Business> businesses;
    private int total;

    public BusinessResults() {
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
