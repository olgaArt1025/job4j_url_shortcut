package ru.job4j.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import ru.job4j.model.Url;
import ru.job4j.repository.UrlDTO;
import ru.job4j.repository.UrlRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlDTO convert(String url) {
        Optional<Url> foundUrl = urlRepository.findByUrl(url);
        if (foundUrl.isPresent()) {
            return new UrlDTO(foundUrl.get().getCode());
        }
        Url newUrl = new Url(url);
        String code = RandomStringUtils.randomAlphanumeric(6);
        newUrl.setCode(code);
        urlRepository.save(newUrl);
        return new UrlDTO(newUrl.getCode());
    }

    public Optional<Url> findByCode(String code) {
        return urlRepository.findByCode(code);
    }

    public void callCounter(String code) {
        urlRepository.callCounter(code);
    }

    public List<Url> getAll() {
        List<Url> rsl = new ArrayList<>();
        urlRepository.findAll().forEach(rsl::add);
        return rsl;
    }
}
