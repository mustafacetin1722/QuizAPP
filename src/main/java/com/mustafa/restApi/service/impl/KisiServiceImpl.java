package com.mustafa.restApi.service.impl;

import com.mustafa.restApi.dto.KisiDto;
import com.mustafa.restApi.entity.Adres;
import com.mustafa.restApi.entity.Kisi;
import com.mustafa.restApi.repo.AdresRepostory;
import com.mustafa.restApi.repo.KisiRepostory;
import com.mustafa.restApi.service.KisiService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {
    private final KisiRepostory kisiRepostory;
    private final AdresRepostory adresRepostory;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi=new Kisi();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyAd(kisiDto.getSoyAd());
        final Kisi kisidb=kisiRepostory.save(kisi);
        List<Adres> list=new ArrayList<>();

        kisiDto.getAdresler().forEach(item ->{
            Adres adres=new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisidb);
            list.add(adres);
        });
        adresRepostory.saveAll(list);
        kisiDto.setId(kisidb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler=kisiRepostory.findAll();
        List<KisiDto> kisiDtos=new ArrayList<>();

        kisiler.forEach(item -> {
            KisiDto kisiDto=new KisiDto();
            kisiDto.setId(item.getId());
            kisiDto.setAd(item.getAd());
            kisiDto.setSoyAd(item.getSoyAd());
            kisiDto.setAdresler(item.getAdresler().stream()
                    .map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }


    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
