package com.inovatech.br.heritage.service;

import com.inovatech.br.heritage.dto.HeritageCreateDTO;
import com.inovatech.br.heritage.dto.HeritageViewDTO;
import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.model.entities.User;
import com.inovatech.br.heritage.repository.HeritageRepository;
import com.inovatech.br.heritage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeritageService {

    @Autowired
    private HeritageRepository heritageRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<HeritageViewDTO>> findAllForCommonUser() {
        List<Heritage> list = heritageRepository.findAll();
        List<HeritageViewDTO> listDTO = new ArrayList<>();
        for (Heritage h : list) {
            HeritageViewDTO heritageViewDTO = new HeritageViewDTO(
                    h.getName(),
                    h.getCode(),
                    h.getDescription(),
                    h.getCategory(),
                    h.getStatus()
            );
            listDTO.add(heritageViewDTO);
        }

        return ResponseEntity.ok().body(listDTO);
    }

    public ResponseEntity<Heritage> save(HeritageCreateDTO dto) {
        User userDefault = userRepository.findById(1L).orElseThrow(()
                -> new RuntimeException("Usuario nao encontrado"));

        Heritage heritage = new Heritage();
        heritage.setName(dto.name());
        heritage.setCode(dto.code());
        heritage.setDescription(dto.description());
        heritage.setImage(dto.image());
        heritage.setCategory(dto.category());
        heritage.setHeritageValue(dto.heritageValue());
        heritage.setDateOfPurchase(dto.dateOfPurchase());
        heritage.setLocation(dto.location());
        heritage.setStatus(dto.status());

        heritage.setCreateBy(userDefault);
        Heritage heritageSaved = heritageRepository.save(heritage);
        return ResponseEntity.status(201).body(heritageSaved);
    }

}
