package com.inovatech.br.patrimonio;

import com.inovatech.br.patrimonio.model.entities.Heritage;
import com.inovatech.br.patrimonio.model.enums.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PatrimonioApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatrimonioApplication.class, args);
	}
}
