package com.ftninformatika.jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Festival;
import com.ftninformatika.jwd.model.Rezervacija;
import com.ftninformatika.jwd.repository.RezervacijaRepository;
import com.ftninformatika.jwd.service.FestivalService;
import com.ftninformatika.jwd.service.RezervacijaService;

@Service
public class JpaRezervacijaService implements RezervacijaService {

	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Autowired
	private FestivalService festivalService;

	@Override
	public Rezervacija findOne(Long id) {		
		return rezervacijaRepository.findOneById(id);
	}

	@Override
	public List<Rezervacija> findAll() {
		return rezervacijaRepository.findAll();
	}

	@Override
	public Rezervacija save(Rezervacija rezervacija) {
		Festival festival = rezervacija.getFestival();
		int dostupneKarte = festival.getBrojDostupnihKarata() - rezervacija.getBrojKupljenihKarata();
		festival.setBrojDostupnihKarata(dostupneKarte);
		festival.getRezervacije().add(rezervacija);
		festivalService.save(festival);

		double ukupnaCena = rezervacija.getBrojKupljenihKarata() * festival.getCenaKarte();
		rezervacija.setUkupnaCena(ukupnaCena);

		return rezervacijaRepository.save(rezervacija);
	}
}