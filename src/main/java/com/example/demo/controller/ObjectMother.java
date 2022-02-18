package com.example.demo.controller;

import com.example.demo.model.Movil;
import com.example.demo.model.MovilBuilder;



public class ObjectMother {
	
	MovilBuilder movilBuilder;
	
	
	public Movil generarMovil(){
		movilBuilder = new MovilBuilder();
		return movilBuilder.movilBuild();
	}
	
}
