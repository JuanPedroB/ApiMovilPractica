package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovilService;
import com.example.demo.model.Response;


@RestController
@RequestMapping("moviles")
public class MovilController {

	
	@Autowired
	private MovilService movilService;
	
	@GetMapping("homeDos")
	public ResponseEntity<Response> getMoviles(){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.getMoviles()))
				.build());
				
				
	}	
	
	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<Response> buscarMovilMarcaResponse(@PathVariable("marca") String marca){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.getMovilesPorMarca(marca)))
				.build());
		
	}
	
	
	@GetMapping("/bateria/{bateria}")
	public ResponseEntity<Response> buscarMovilBateriaResponse(@PathVariable("bateria") int bateria){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.getMovilesPorBateria(bateria)))
				.build());
		
	}
	
	@GetMapping("/precio/{precio}")
	public ResponseEntity<Response> buscarMovilPrecio(@PathVariable("precio") float precio){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.getMovilesPrecio(precio)))
				.build());
	}
	
	@GetMapping("/ram/{ram}")
	public ResponseEntity<Response> buscarMovilRam(@PathVariable("ram") int ram){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.getMovilesPorRam(ram)))
				.build());
	}
	
	@GetMapping("/{marca}/{bateria}/{precio}/{ram}")
	public ResponseEntity<Response> buscarMovilPorFiltros(@PathVariable("marca") String marca, @PathVariable("bateria") int bateria,@PathVariable("precio") float precio,@PathVariable("ram") int ram){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.buscarMovilesFiltros(marca, bateria, precio, ram)))
				.build());
	}
	
	@GetMapping("/{compararUno}/{compararDos}")
	public ResponseEntity<Response> compararMoviles(@PathVariable("compararUno") String marcaUno, @PathVariable("compararDos") String marcaDos){
		return ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("Moviles cogidos")
				.Status(HttpStatus.OK)
				.Data(Map.of("moviles", movilService.compararMoviles(marcaUno, marcaDos)))
				.build());
	}
	
}
