package ru.job4j.repository;

import java.util.Objects;

public class UrlDtoStat {
    private String url;
    private int count;

    public UrlDtoStat(String url, int count) {
        this.url = url;
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UrlDtoStat that = (UrlDtoStat) o;
        return count == that.count && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, count);
    }
}
