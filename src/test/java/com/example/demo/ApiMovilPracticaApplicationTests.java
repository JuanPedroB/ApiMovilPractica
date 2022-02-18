package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.ObjectMother;
import com.example.demo.model.Movil;
import com.example.demo.model.MovilRepository;

@SpringBootTest
class ApiMovilPracticaApplicationTests {

	@Autowired
	MovilRepository movilRepository;

	@Test
	void contextLoads() {
		
		
		ObjectMother objectMother = new ObjectMother();
		Set<Movil> listaMoviles = new HashSet<>();
		
		for (int i = 0; i < 50; i++) {
			listaMoviles.add(objectMother.generarMovil());
		}
		
		listaMoviles.forEach((a)->{System.out.println(a.toString());});
		movilRepository.saveAll(listaMoviles);
	
	}

}
