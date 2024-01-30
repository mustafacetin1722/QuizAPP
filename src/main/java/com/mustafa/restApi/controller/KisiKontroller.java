package com.mustafa.restApi.controller;

import com.mustafa.restApi.dto.KisiDto;
import com.mustafa.restApi.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiKontroller {

    private final KisiService kisiService;

    @GetMapping
    public ResponseEntity<List<KisiDto>> listele(){
        return ResponseEntity.ok(kisiService.getAll());
    }
    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }

}
