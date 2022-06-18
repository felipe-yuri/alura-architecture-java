package br.com.alura.domain.entities;

import java.time.LocalDateTime;

public class Indication {

	private StudentEntity indicated;
	private StudentEntity indicator;
	private LocalDateTime indicationDate;

	public Indication(StudentEntity indicated, StudentEntity indicator) {
		this.indicated = indicated;
		this.indicator = indicator;
		this.indicationDate = LocalDateTime.now();
	}

	public StudentEntity getIndicated() {
		return indicated;
	}

	public StudentEntity getIndicator() {
		return indicator;
	}

	public LocalDateTime getIndicationDate() {
		return indicationDate;
	}

}
