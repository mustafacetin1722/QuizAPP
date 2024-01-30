package com.mustafa.restApi.dto;

import com.mustafa.restApi.entity.Adres;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class KisiDto {
    private Long id;
    private  String ad;
    private  String soyAd;
    private List<String> adresler;
}
