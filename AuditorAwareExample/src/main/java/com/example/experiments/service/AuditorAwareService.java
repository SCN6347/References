package com.example.experiments.service;

import com.example.experiments.dto.AuditorAwareDto;

public interface AuditorAwareService {

	void createAuditorAwareRecord(AuditorAwareDto auditorAwareDto);

	long getAuditorAwareRecordcount();

	AuditorAwareDto getAuditorAwareRecord(Integer id);

	AuditorAwareDto updateAuditorAwareRecord(AuditorAwareDto auditorAwareDto);

	void deleteAuditorAwareRecord(Integer id);

}
