package com.ftninformatika.jwd.service;

import java.util.List;

import com.ftninformatika.jwd.model.Mesto;

public interface MestoService {
	
	List<Mesto> findAll();

	Mesto findOne(Long id);

}
