package com.tsvhlpom.compare.utils;

public class ComparisonResult {
    private String key;
    //private String label;
    private String previous;
    private String later;
    //private String table_name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

   /* public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }*/

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getLater() {
        return later;
    }

    public void setLater(String later) {
        this.later = later;
    }

    /*public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }*/
}
