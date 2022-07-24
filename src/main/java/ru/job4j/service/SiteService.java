package ru.job4j.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.model.Site;
import ru.job4j.repository.SiteDTO;
import ru.job4j.repository.SiteRepository;

import java.util.Optional;
import org.apache.commons.lang3.RandomStringUtils;

@Service
public class SiteService {
    private final SiteRepository siteRepository;
    private BCryptPasswordEncoder encoder;

    public SiteService(SiteRepository siteRepository, BCryptPasswordEncoder encoder) {
        this.siteRepository = siteRepository;
        this.encoder = encoder;
    }

    public SiteDTO registration(Site site) {
        Optional<Site> findSite = siteRepository.findBySite(site.getSite());
        if (findSite.isPresent()) {
            return new SiteDTO(
                    false, findSite.get().getLogin(), findSite.get().getPassword()
            );
        }
        String login =  RandomStringUtils.randomAlphanumeric(8);
        site.setLogin(login);
        String password = RandomStringUtils.randomAlphanumeric(8);
        site.setPassword(encoder.encode(password));
        siteRepository.save(site);
        return new SiteDTO(true, site.getLogin(), site.getPassword());
    }

    public Site findByLogin(String login) {
       return siteRepository.findByLogin(login);
    }
}
