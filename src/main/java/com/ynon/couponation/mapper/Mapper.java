package com.ynon.couponation.mapper;

import com.ynon.couponation.exceptions.ApplicationException;

import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
public interface Mapper<DAO,DTO> {

    DAO toDao(DTO dto) throws ApplicationException;
    DTO toDto(DAO dao);
    List<DAO> toDaoList(List<DTO> dtos) throws ApplicationException;
    List<DTO> toDtoList(List<DAO> daos);

}
