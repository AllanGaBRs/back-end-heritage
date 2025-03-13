package com.inovatech.br.heritage.repository;

import com.inovatech.br.heritage.model.entities.Heritage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeritageRepository extends JpaRepository<Heritage, Long> {
}
