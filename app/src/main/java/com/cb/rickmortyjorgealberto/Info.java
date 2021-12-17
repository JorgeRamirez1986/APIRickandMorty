package com.cb.rickmortyjorgealberto;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("count")
   
    private Integer count;
    @SerializedName("pages")
   
    private Integer pages;
    @SerializedName("next")
   
    private String next;
    @SerializedName("prev")
   
    private String prev;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

}
