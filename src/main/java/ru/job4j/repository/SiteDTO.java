package ru.job4j.repository;

import java.util.Objects;

public class SiteDTO {
    private boolean registration;
    private String login;
    private String password;

    public SiteDTO(boolean registration, String login, String password) {
        this.registration = registration;
        this.login = login;
        this.password = password;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SiteDTO siteDTO = (SiteDTO) o;
        return registration == siteDTO.registration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registration);
    }
}
