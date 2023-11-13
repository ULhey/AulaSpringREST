package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bme280;
import com.example.demo.model.Bme280Dto;
import com.example.demo.repository.Bme280Repository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class Bme280Controller {
	@Autowired
	private Bme280Repository brep;

	@GetMapping("/bme")
	public List<Bme280Dto> lista() {
		return converteLista(brep.findAll());
	}

	@GetMapping("/bme/{dataHora}")
	public ResponseEntity<Bme280Dto> busca (@PathVariable(value = "dataHora") LocalDate d) {
		Bme280 b = brep.findById(d).orElseThrow(() -> new ResourceNotFoundException("Código inválido"));
		Bme280Dto bdto = converteDto(b);
		return ResponseEntity.ok().body(bdto);
	}

	@PostMapping("/bme")
	public ResponseEntity<String> adiciona(@Valid @RequestBody Bme280Dto bmeDto) {
		Bme280 b = converteBme(bmeDto);
		brep.save(b);
		String saida = "Depto adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@PutMapping("/bme")
	public ResponseEntity<String> atualiza(@Valid @RequestBody Bme280Dto bmeDto) {
		Bme280 b = converteBme(bmeDto);
		brep.save(b);
		String saida = "Depto adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@DeleteMapping("/bme")
	public ResponseEntity<String> exclui(@Valid @RequestBody Bme280Dto bmeDto) {
		Bme280 b = converteBme(bmeDto);
		brep.delete(b);
		String saida = "Depto excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	private List<Bme280Dto> converteLista(List<Bme280> lista) {
		List<Bme280Dto> listaDTO = new ArrayList<>();
		for (Bme280 b : lista) {
			Bme280Dto bDto = new Bme280Dto();
			bDto.setLocalDateTime(b.getLocalDateTime());
			bDto.setHumidade(b.getHumidade());
			bDto.setPressao(b.getPressao());
			bDto.setTemperatura(b.getTemperatura());
			listaDTO.add(bDto);
		}
		return listaDTO;
	}

	private Bme280Dto converteDto(Bme280 b) {
		Bme280Dto bDto = new Bme280Dto();
		bDto.setLocalDateTime(b.getLocalDateTime());
		bDto.setHumidade(b.getHumidade());
		bDto.setPressao(b.getPressao());
		bDto.setTemperatura(b.getTemperatura());
		return bDto;
	}

	private Bme280 converteBme(Bme280Dto bDto) {
		Bme280 b = new Bme280();
		b.setLocalDateTime(bDto.getLocalDateTime());
		b.setHumidade(bDto.getHumidade());
		b.setPressao(bDto.getPressao());
		b.setTemperatura(bDto.getTemperatura());
		return b;
	}
}
