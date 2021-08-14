package com.ynon.couponation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ynon on  15-Aug-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrDto {
    private final String key = "Oooops...";
    private String message;
}
