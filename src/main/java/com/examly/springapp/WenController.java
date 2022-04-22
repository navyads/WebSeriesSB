package com.examly.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WenController {
    
    @Autowired
    public WebService ws;

    @PostMapping("/addSeries")
    public void addSeries(@RequestBody Web web){
        ws.addSeries(web);
    }

    @PostMapping("/update")
    public void editSeries(@PathVariable String id, @RequestBody Web web) {
        ws.editSeries(id, web);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeries(@PathVariable String id){
        ws.deleteSeries(id);
    }

    @GetMapping("/series")
    public List<Web> getAllSeries(){
        return ws.getAllSeries();
    }

    @GetMapping("/series/id/{id}")
    public Web getById(@PathVariable String id, @RequestBody Web web){
        return ws.getById(id, web);
    }

    @GetMapping("/series/name/{name}")
    public List<Web> getByName(@PathVariable String name, @RequestBody Web web){
        return ws.getByName(name, web);
    }
}
