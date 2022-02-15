package com.zenika.tz.trunkkata.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Consumer;

import org.springframework.util.StringUtils;

public final class Rating {
    private final LocalDateTime date;
    private final String beer;
    private final String user;
    private final int rate;

    public Rating(final String beer, final String user, final int rate) {
        if (!StringUtils.hasText(beer)) {
            throw new IllegalArgumentException("beer should have text");
        }
        if (!StringUtils.hasText(user)) {
            throw new IllegalArgumentException("user should have text");
        }
        if (rate < 1 || rate > 5) {
            throw new IllegalArgumentException("rate should be between 1 and 5");
        }

        this.date = LocalDateTime.now();
        this.beer = beer;
        this.user = user;
        this.rate = rate;
    }

    public void create(Consumer<Rating> saveFunction) {
        // TODO add tests
        // TODO TDD duplication check
        // TODO implement duplication check && feature flag
        saveFunction.accept(this);
    }



















    // BOILER PLATE CODE =)
    public LocalDateTime date() {
        return date;
    }

    public String beer() {
        return beer;
    }

    public String user() {
        return user;
    }

    public int rate() {
        return rate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Rating) obj;
        return Objects.equals(this.date, that.date) &&
                Objects.equals(this.beer, that.beer) &&
                Objects.equals(this.user, that.user) &&
                this.rate == that.rate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, beer, user, rate);
    }

    @Override
    public String toString() {
        return "Rating[" +
                "date=" + date + ", " +
                "beer=" + beer + ", " +
                "user=" + user + ", " +
                "rate=" + rate + ']';
    }

}
