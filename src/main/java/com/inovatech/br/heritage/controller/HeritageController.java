package com.inovatech.br.heritage.controller;

import com.inovatech.br.heritage.dto.HeritageCreateDTO;
import com.inovatech.br.heritage.dto.HeritageViewDTO;
import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.service.HeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/heritage")
public class HeritageController {

    @Autowired
    private HeritageService heritageService;

    @GetMapping("/list")
    public ResponseEntity<List<HeritageViewDTO>> listAllForCommonUser(){
        List<HeritageViewDTO> list = heritageService.findAllForCommonUser();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/save")
    public ResponseEntity<Heritage> saveHeritage(@RequestBody HeritageCreateDTO heritageDTO){
       Heritage heritage = heritageService.save(heritageDTO);
       return ResponseEntity.status(201).body(heritage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeritageViewDTO> findById(@PathVariable Long id){
        HeritageViewDTO heritage = heritageService.findById(id);
        return ResponseEntity.ok().body(heritage);
    }

}
