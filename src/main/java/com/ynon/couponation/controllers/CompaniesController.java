package com.ynon.couponation.controllers;

import com.ynon.couponation.dtos.CompanyDto;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.services.CompaniesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompaniesController {

    private final CompaniesService companiesService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public @ResponseBody
    CompanyDto addCompany(@RequestBody CompanyDto company){
        return this.companiesService.createCompany(company);
    }

    //RETRIEVE
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CompanyDto> getAllCompanies(){
        return this.companiesService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable long id) throws ApplicationException {
        return this.companiesService.getCompany(id);
    }

    //UPDATE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public CompanyDto updateCompany(@PathVariable long id, @RequestBody CompanyDto company) throws ApplicationException {
        return this.companiesService.updateCompany(id,company);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable long id) throws ApplicationException {
        this.companiesService.deleteCompany(id);
    }

}
