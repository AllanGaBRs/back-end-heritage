package com.inovatech.br.heritage.service;

import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.repository.HeritageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeritageService {

    @Autowired
    private HeritageRepository heritageRepository;

    public List<Heritage> findAll(){
        return heritageRepository.findAll();
    }

    public Heritage save(Heritage heritage){
        return heritageRepository.save(heritage);
    }

}
