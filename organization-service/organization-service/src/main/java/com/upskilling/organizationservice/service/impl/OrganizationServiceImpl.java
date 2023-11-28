package com.upskilling.organizationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upskilling.organizationservice.Mapper.OrganizationMapper;
import com.upskilling.organizationservice.dto.OrganizationDto;
import com.upskilling.organizationservice.entity.Organization;
import com.upskilling.organizationservice.repository.OrganizationRepository;
import com.upskilling.organizationservice.service.OrganizationService;

@Service

public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }


}
