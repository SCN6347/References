package com.example.experiments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.experiments.dao.entity.AuditorAwareEntity;
import com.example.experiments.dao.repository.AuditorAwareRepository;
import com.example.experiments.dto.AuditorAwareDto;

@Service
public class AuditorAwareServiceImpl implements AuditorAwareService {
	
	@Autowired
	private AuditorAwareRepository auditorAwareRepository;

	@Override
	public void createAuditorAwareRecord(AuditorAwareDto auditorAwareDto) {
	
		AuditorAwareEntity auditorAwareEntity = new AuditorAwareEntity(auditorAwareDto);
		auditorAwareRepository.save(auditorAwareEntity);
	}

	@Override
	public long getAuditorAwareRecordcount() {
		 
		// repository.count() returns the number of records in the table for the entity.
		return auditorAwareRepository.count();

	}

	@Override
	public AuditorAwareDto getAuditorAwareRecord(Integer id) {
		
		Optional<AuditorAwareEntity> searchResult = auditorAwareRepository.findById(id);
		if(searchResult.isPresent()) 
		{
			return new AuditorAwareDto(searchResult.get());
		}
		else return null;

	}

	@Override
	public AuditorAwareDto updateAuditorAwareRecord(AuditorAwareDto auditorAwareDto) {
		
		Optional<AuditorAwareEntity> searchResult = auditorAwareRepository.findById(auditorAwareDto.getId());
		if(searchResult.isPresent()) 
		{
			AuditorAwareEntity auditorAwareEntity = searchResult.get();
			auditorAwareEntity.setPlayerName(auditorAwareDto.getPlayerName());
			auditorAwareEntity.setPalyingForTeam(auditorAwareDto.getPalyingForTeam());
			auditorAwareRepository.save(auditorAwareEntity);
			return auditorAwareDto;
		}
		else return null;
	}

	@Override
	public void deleteAuditorAwareRecord(Integer id) {
		auditorAwareRepository.deleteById(id);
	}

}
