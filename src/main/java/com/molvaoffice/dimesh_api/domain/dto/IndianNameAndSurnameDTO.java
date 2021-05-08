package com.molvaoffice.dimesh_api.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IndianNameAndSurnameDTO {
    private String indianName;
    private String indianSurname;
    private String indianNameMeaning;
    private String indianSurnameMeaning;
}
