package com.ynon.couponation.services;

import com.ynon.couponation.dtos.CompanyDto;
import com.ynon.couponation.exceptions.ApplicationException;

import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
public interface CompaniesServiceInterface {
    //Create
    CompanyDto createCompany(CompanyDto companyDto);

    //Retrieve
    CompanyDto getCompany(long id) throws ApplicationException;
    List<CompanyDto> getAllCompanies();

    //Update
    CompanyDto updateCompany(long id, CompanyDto companyDto) throws ApplicationException;

    //Delete
    void deleteCompany(long id) throws ApplicationException;


    boolean isExistById(long id);


}
