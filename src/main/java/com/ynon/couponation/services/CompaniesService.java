package com.ynon.couponation.services;

import com.ynon.couponation.dtos.CompanyDto;
import com.ynon.couponation.entities.Company;
import com.ynon.couponation.entities.User;
import com.ynon.couponation.enums.ErrType;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.mapper.CompanyMapper;
import com.ynon.couponation.repositories.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CompaniesService implements CompaniesServiceInterface {

    private final CompanyRepo companyRepository;
    private final CompanyMapper mapper;


    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        return mapper.toDto(companyRepository.save(mapper.toDao(companyDto)));
    }

    @Override
    public CompanyDto getCompany(long id) throws ApplicationException {
        if (!isExistById(id)) {
            throw new ApplicationException(ErrType.COMPANY_NOT_EXIST);
        }
        return mapper.toDto(companyRepository.findById(id).get());
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        return mapper.toDtoList(companyRepository.findAll());
    }

    @Override
    public CompanyDto updateCompany(long id, CompanyDto companyDto) throws ApplicationException {

        if (!companyRepository.existsById(id)) {
            throw new ApplicationException(ErrType.COMPANY_NOT_EXIST);
        }

        Company c = companyRepository.findById(id).get();
        c.setEmail(companyDto.getEmail());
        c.setWebsite(companyDto.getWebSite());
        c.setAddress(companyDto.getAddress());
        c.setPhone(companyDto.getPhone());

        return mapper.toDto(companyRepository.save(c));

    }

    @Override
    public void deleteCompany(long id) throws ApplicationException {
        if (!isExistById(id)) {
            throw new ApplicationException(ErrType.COMPANY_NOT_EXIST);
        }
        companyRepository.deleteById(id);
    }

    @Override
    public boolean isExistById(long id) {
        return companyRepository.existsById(id);
    }
}
