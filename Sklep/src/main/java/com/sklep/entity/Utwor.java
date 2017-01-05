package com.sklep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utwor")
public class Utwor implements Serializable {

	@Id
	@GeneratedValue
	private int Utwor_ID;

	@Column(name = "UtworNazwa")
	private String utworNazwa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Album_ID")
	private Album Album;
	
	

	public Utwor() {
	};

	public int getId() {
		return Utwor_ID;
	}
	

	public String getUtworNazwa() {
		return utworNazwa;
	}

	public void setUtworNazwa(String utworNazwa) {
		this.utworNazwa = utworNazwa;
	}

}