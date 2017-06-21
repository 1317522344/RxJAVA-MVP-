package com.example.administrator.mygankclient.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/17.
 */

public class RootBean {
    private List<String> category ;

    private boolean error;

    private ResultBean results;

    public void setString(List<String> category){
        this.category = category;
    }
    public List<String> getString(){
        return this.category;
    }
    public void setError(boolean error){
        this.error = error;
    }
    public boolean getError(){
        return this.error;
    }
    public void setResults(ResultBean results){
        this.results = results;
    }
    public ResultBean getResults(){
        return this.results;
    }

}
