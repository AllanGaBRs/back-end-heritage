package com.inovatech.br.heritage.controller;

import com.inovatech.br.heritage.dto.HeritageCreateDTO;
import com.inovatech.br.heritage.dto.HeritageViewDTO;
import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.service.HeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heritage")
public class HeritageController {

    @Autowired
    private HeritageService heritageService;

    @GetMapping
    public ResponseEntity<List<HeritageViewDTO>> listAllForCommonUser(){
        return heritageService.findAllForCommonUser();
    }

    @PostMapping("/save")
    public ResponseEntity<Heritage> saveHeritage(@RequestBody HeritageCreateDTO heritageDTO){
        return heritageService.save(heritageDTO);
    }

}
