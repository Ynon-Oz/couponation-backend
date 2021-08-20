package com.ynon.couponation.clr;

import com.ynon.couponation.dtos.CompanyDto;
import com.ynon.couponation.mapper.CompanyMapper;
import com.ynon.couponation.services.CompaniesService;
import com.ynon.couponation.utils.ArtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Ynon on  15-Aug-21
 */
@Component
public class CompaniesMocking implements CommandLineRunner {
    @Autowired
    private CompaniesService companiesService;
    @Autowired
    private CompanyMapper mapper;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.startingCompaniesTests);

        CompanyDto c1 = CompanyDto.builder()
                .email("sales@zara.co.il")
                .address("34 Joul Vern st Rehovot")
                .name("ZARA")
                .phone("0777568977")
                .webSite("www.zara.co.il")
                .build();
        System.out.println("Adding Company: "+c1);
        System.out.println(companiesService.createCompany(c1));
        CompanyDto c2 = CompanyDto.builder()
                .email("sales@Giraf.co.il")
                .address("34 Eben Gavirol st Tel-Aviv")
                .name("Giraf")
                .phone("0745678963")
                .webSite("www.Giraf.com")
                .build();
        System.out.println("Adding Company: "+c2);
        System.out.println(companiesService.createCompany(c2));
        System.out.println("********************************************************************");
        System.out.println("Get company #: 2");
        System.out.println(companiesService.getCompany(2));
        System.out.println("********************************************************************");
        System.out.println("Delete company #2");
        companiesService.deleteCompany(2);
        System.out.println("********************************************************************");
        System.out.println("Update company #1: ");
        c2.setWebSite("www.farig.org.il");
        System.out.println(companiesService.updateCompany(1,c2));
        System.out.println("********************************************************************");
        System.out.println("Get all companies: ");
        companiesService.getAllCompanies().forEach(System.out::println);
        System.out.println("********************************************************************");



    }
}
