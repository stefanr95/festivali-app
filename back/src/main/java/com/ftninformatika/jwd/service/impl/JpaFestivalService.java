package com.ftninformatika.jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.model.Festival;
import com.ftninformatika.jwd.repository.FestivalRepository;
import com.ftninformatika.jwd.service.FestivalService;

@Service
public class JpaFestivalService implements FestivalService{

	@Autowired
	private FestivalRepository festivalRepository;
	
	@Override
	public Festival findOne(Long id) {
		return festivalRepository.findOneById(id);
	}

	@Override
	public Festival delete(Long id) {
		Festival festival = findOne(id);
		if(festival != null) {
			festival.getMesto().getFestivali().remove(festival);
			festival.setMesto(null);
			festival = festivalRepository.save(festival);
			festivalRepository.delete(festival);
			
			return festival;
		}
		
		return null;
	}

	@Override
	public Festival update(Festival festival) {
		return festivalRepository.save(festival);
	}

	@Override
	public Festival save(Festival festival) {
		return festivalRepository.save(festival);
	}

	@Override
	public Page<Festival> findAll(Long mestoId, String naziv, int pageNo) {
		if(naziv == null) {
			naziv = "";
		}
		if(mestoId == null) {
			return festivalRepository.findByNazivIgnoreCaseContains(naziv, PageRequest.of(pageNo, 3));
		}
		
		return festivalRepository.findByNazivIgnoreCaseContainsAndMestoId(naziv, mestoId, PageRequest.of(pageNo, 3));
	}

}