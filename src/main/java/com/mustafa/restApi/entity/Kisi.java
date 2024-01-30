package com.mustafa.restApi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Kisi {
    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "ad",length = 100)
    private  String ad
            ;
    @Column(name = "soyAd",length = 100)
    private  String soyAd;
    @JoinColumn(name = "kisi_adres_id")
    @OneToMany
    private List<Adres> adresler;
}
