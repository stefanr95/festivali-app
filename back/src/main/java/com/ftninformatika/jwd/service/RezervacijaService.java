package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Rezervacija;

public interface RezervacijaService {

	Rezervacija findOne(Long id);

	Rezervacija save(Rezervacija rezervacija);

	List<Rezervacija> findAll();

}
