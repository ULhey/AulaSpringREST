package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bme280")
public class Bme280 {
	@Id 
	@Column(name = "localDateTime", nullable = false)
	private LocalDate localDateTime;
	
	@Column(name = "pressao", scale = 2, precision = 7)
	private BigDecimal pressao;
	
	@Column(name = "humidade", scale = 2, precision = 4)
	private BigDecimal humidade;
	
	@Column(name = "temperatura", scale = 2, precision = 4)
	private BigDecimal temperatura;
	
	public LocalDate getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDate localDateTime) {
		this.localDateTime = localDateTime;
	}

	public BigDecimal getPressao() {
		return pressao;
	}

	public void setPressao(BigDecimal pressao) {
		this.pressao = pressao;
	}

	public BigDecimal getHumidade() {
		return humidade;
	}

	public void setHumidade(BigDecimal humidade) {
		this.humidade = humidade;
	}

	public BigDecimal getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}
	
}
