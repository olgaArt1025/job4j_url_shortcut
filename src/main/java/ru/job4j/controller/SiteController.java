package ru.job4j.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Site;
import ru.job4j.repository.SiteDTO;
import ru.job4j.service.SiteService;

@RestController
public class SiteController {

    private SiteService siteServise;
    private BCryptPasswordEncoder encoder;

    public SiteController(SiteService siteServise,
                          BCryptPasswordEncoder encoder) {
        this.siteServise = siteServise;
        this.encoder = encoder;
    }

    @PostMapping("/registration")
    public SiteDTO registration(@RequestBody Site site) {
        return siteServise.registration(site);
    }
}
