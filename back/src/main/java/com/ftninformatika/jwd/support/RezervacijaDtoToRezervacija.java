package com.ftninformatika.jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.model.Rezervacija;
import com.ftninformatika.jwd.service.FestivalService;
import com.ftninformatika.jwd.service.RezervacijaService;
import com.ftninformatika.jwd.web.dto.RezervacijaDTO;

@Component
public class RezervacijaDtoToRezervacija implements Converter<RezervacijaDTO, Rezervacija> {

	@Autowired
	private RezervacijaService rezervacijaService;

	@Autowired
	private FestivalService festivalService;

	@Override
	public Rezervacija convert(RezervacijaDTO dto) {
		Rezervacija rezervacija;

		if(dto.getId() == null) {
			rezervacija = new Rezervacija();
		} else {
			rezervacija = rezervacijaService.findOne(dto.getId());
		}

		if(rezervacija != null) {
			rezervacija.setBrojKupljenihKarata(dto.getBrojKupljenihKarata());
			rezervacija.setUkupnaCena(dto.getUkupnaCena());
			rezervacija.setFestival(festivalService.findOne(dto.getFestivalDTO().getId()));
		}

		return rezervacija;
	}
}
