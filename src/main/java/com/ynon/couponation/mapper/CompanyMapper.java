package com.ynon.couponation.mapper;

import com.ynon.couponation.dtos.CompanyDto;
import com.ynon.couponation.entities.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@Component
public class CompanyMapper implements Mapper<Company, CompanyDto> {


    @Override
    public Company toDao(CompanyDto companyDto) {
        return Company.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .email(companyDto.getEmail())
                .address(companyDto.getAddress())
                .phone(companyDto.getPhone())
                .website(companyDto.getWebSite())
//                .coupons(companyDto.getCoupons())
//                .users(companyDto.getUsers().stream().forEach(user -> user.getCompanyId());)
                .build();
    }

    @Override
    public CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .address(company.getAddress())
                .phone(company.getPhone())
                .webSite(company.getWebsite())
//                .coupons(company.getCoupons())
//                .users(company.getUsers())
                .build();
    }

    @Override
    public List<Company> toDaoList(List<CompanyDto> companyDtos) {
        List<Company> companies = new ArrayList<>();
        companyDtos.forEach(companyDto -> companies.add(toDao(companyDto)));
        return companies;
    }

    @Override
    public List<CompanyDto> toDtoList(List<Company> companies) {
        List<CompanyDto> dtos = new ArrayList<>();
        companies.forEach(company -> dtos.add(toDto(company)));
        return dtos;
    }
}
