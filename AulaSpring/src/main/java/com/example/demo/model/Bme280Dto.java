package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Bme280Dto {
	private LocalDate localDateTime;
	private BigDecimal pressao;
	private BigDecimal humidade;
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
