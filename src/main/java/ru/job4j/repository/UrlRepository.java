package ru.job4j.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.model.Url;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UrlRepository  extends CrudRepository<Url, Integer> {

    Optional<Url> findByUrl(String url);

    Optional<Url> findByCode(String code);

    @Transactional
    @Modifying
    @Query("update Url u set u.count = u.count + 1 where u.code = :fCode")
    void callCounter(@Param("fCode") String code);
}
