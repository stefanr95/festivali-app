package com.ftninformatika.jwd.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.model.Festival;
import com.ftninformatika.jwd.service.FestivalService;
import com.ftninformatika.jwd.support.FestivalDtoToFestival;
import com.ftninformatika.jwd.support.FestivalToFestivalDto;
import com.ftninformatika.jwd.web.dto.FestivalDTO;

@RestController
@RequestMapping(value = "/api/festivali", produces = MediaType.APPLICATION_JSON_VALUE)
public class FestivalController {

	@Autowired
	private FestivalService festivalService;

	@Autowired
	private FestivalDtoToFestival toFestival;

	@Autowired
	private FestivalToFestivalDto toFestivalDto;

	//preuzimanje svih festivala PAGINIRANO
	@GetMapping
	public ResponseEntity<List<FestivalDTO>> getAll(
			@RequestParam (required=false) Long mestoId,
			@RequestParam (required=false) String naziv,
			@RequestParam (value = "pageNo", defaultValue = "0") int pageNo) {


		Page<Festival> page = festivalService.findAll(mestoId, naziv, pageNo);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toFestivalDto.convert(page.getContent()), headers, HttpStatus.OK);

	}

	//preuzimanje festivala po zadatom ID
	@GetMapping("/{id}")
	public ResponseEntity<FestivalDTO> getOne(@PathVariable Long id) {
		Festival festival = festivalService.findOne(id);

		if(festival != null) {
			return new ResponseEntity<>(toFestivalDto.convert(festival), HttpStatus.OK);
		} 

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	

	}

	//dodavanje novog festivala
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FestivalDTO> create(@Valid @RequestBody FestivalDTO festivalDTO){
		Festival festival = toFestival.convert(festivalDTO);

		if(festival.getMesto() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


		Festival saveFestival= festivalService.save(festival);

		return new ResponseEntity<>(toFestivalDto.convert(saveFestival), HttpStatus.CREATED);
	}

	//izmena postojeceg festivala
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FestivalDTO> update(@PathVariable Long id, @Valid @RequestBody FestivalDTO festivalDTO){

		if(!id.equals(festivalDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Festival festival = toFestival.convert(festivalDTO);

		if(festival.getMesto() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Festival saveFestival = festivalService.update(festival);

		return new ResponseEntity<>(toFestivalDto.convert(saveFestival),HttpStatus.OK);
	}

	//brisanje postojeceg festivala
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Festival deleteFestival = festivalService.delete(id);

		if(deleteFestival != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}