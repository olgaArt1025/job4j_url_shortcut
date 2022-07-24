package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Site;

import java.util.Optional;

public interface SiteRepository extends CrudRepository<Site, Integer> {

    Site findByLogin(String login);

    Optional<Site> findBySite(String site);
}