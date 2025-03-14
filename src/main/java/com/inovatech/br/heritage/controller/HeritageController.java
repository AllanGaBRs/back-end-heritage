package com.inovatech.br.heritage.controller;

import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.service.HeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heritage")
public class HeritageController {

    @Autowired
    private HeritageService heritageService;

    @GetMapping
    public List<Heritage> listAll(){
        return heritageService.findAll();
    }

    @PostMapping("/save")
    public Heritage saveHeritage(@RequestBody Heritage heritage){
        return heritageService.save(heritage);
    }

}
