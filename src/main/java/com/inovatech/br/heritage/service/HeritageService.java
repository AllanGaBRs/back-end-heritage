package com.inovatech.br.heritage.service;

import com.inovatech.br.heritage.dto.HeritageCreateDTO;
import com.inovatech.br.heritage.dto.HeritageViewDTO;
import com.inovatech.br.heritage.model.entities.Heritage;
import com.inovatech.br.heritage.model.entities.User;
import com.inovatech.br.heritage.repository.HeritageRepository;
import com.inovatech.br.heritage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeritageService {

    @Autowired
    private HeritageRepository heritageRepository;

    @Autowired
    private UserRepository userRepository;

    public List<HeritageViewDTO> findAllForCommonUser() {
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

        return listDTO;
    }

    public Heritage save(HeritageCreateDTO dto) {

        User user = userRepository.findById(1L).orElseThrow(()
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

        heritage.setCreateBy(user);
        heritage.setModifiedBy(user);
        return heritageRepository.save(heritage);
    }

    public HeritageViewDTO findById(Long id){
        return convert(heritageRepository.findById(id).orElse(null));
    }

    private HeritageViewDTO convert(Heritage h){
        if(h == null){
            throw new IllegalArgumentException("O objeto Heritage não pode ser nulo.");
        }
        return new HeritageViewDTO(
                h.getName(),
                h.getCode(),
                h.getDescription(),
                h.getCategory(),
                h.getStatus()
        );
    }
}
