package com.ftninformatika.jwd.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.model.Festival;

public interface FestivalService {

	Festival findOne(Long id);
	
	Festival save(Festival festival);
	
	Festival update(Festival festival);

	Festival delete(Long id);

	Page<Festival> findAll(Long mestoId, String naziv, int pageNo);

}
