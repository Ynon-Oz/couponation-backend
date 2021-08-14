package com.ynon.couponation.mapper;

import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
public interface Mapper<DAO,DTO> {

    DAO toDao(DTO dto) ;
    DTO toDto(DAO dao);
    List<DAO> toDaoList(List<DTO> dtos) ;
    List<DTO> toDtoList(List<DAO> daos);

}
