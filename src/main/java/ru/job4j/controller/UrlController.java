package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.job4j.model.Url;
import ru.job4j.repository.UrlDTO;
import ru.job4j.repository.UrlDtoStat;

import ru.job4j.service.UrlService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/convert")
    public UrlDTO convert(@RequestBody String url) {
        return urlService.convert(url);
    }

    @GetMapping("/redirect/{code}")
    public ResponseEntity<Void> codeToUrl(@PathVariable("code") String code) {
        Optional<Url> url = urlService.findByCode(code);
        if (url.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        urlService.callCounter(url.get().getCode());
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("REDIRECT URL", url.get().getUrl()).build();
    }

    @GetMapping("/statistic")
    public List<UrlDtoStat> statistic() {
        List<UrlDtoStat> rsl = new ArrayList<>();
        List<Url> urls = urlService.getAll();
        for (Url url : urls) {
            UrlDtoStat urlDtoStat = new UrlDtoStat(url.getUrl(), url.getCount());
            rsl.add(urlDtoStat);
        }
        return rsl;
    }
}
