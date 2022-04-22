package com.examly.springapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebService {
    
    @Autowired
    public WebRepository wr;

    public List<Web> getAllSeries(){
        List<Web> w=new ArrayList<Web>();
        wr.findAll().forEach(w::add);
        return w;
    }

    public void addSeries(Web web){
        wr.save(web);
    }

    public void editSeries(String id, Web web){
        wr.save(web);
    }

    public void deleteSeries(String id){
        wr.deleteById(id);
    }

    public Web getById(String id, Web web){
        return wr.findById(id).get();
    }

    public List<Web> getByName(String name, Web web){
        List<Web> a=new ArrayList<Web>();
        web.setName(name);
        if(web.getName().toString()==name)
            a.add(web);
        return a;    
    }
}
