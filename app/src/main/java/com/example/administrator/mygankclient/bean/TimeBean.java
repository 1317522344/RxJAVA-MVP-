package com.example.administrator.mygankclient.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

public class TimeBean {
    private boolean error;
    private List<Date> results;
    public void setError(boolean error) {
        this.error = error;
    }
    public boolean getError() {
        return error;
    }

    public void setResults(List<Date> results) {
        this.results = results;
    }
    public List<Date> getResults() {
        return results;
    }
}
