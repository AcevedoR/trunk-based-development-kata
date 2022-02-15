package com.zenika.tz.trunkkata.dao;

import com.zenika.tz.trunkkata.spi.IRatingRepository;
import com.zenika.tz.trunkkata.domain.Rating;
import com.zenika.tz.trunkkata.entity.RatingEntity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class SimpleInMemoryRatingRepository implements IRatingRepository {
    private final List<RatingEntity> database = new ArrayList<>();
    private long idSequence = 0L;

    @Override
    public void save(final Rating rating) {
        idSequence++;
        database.add(
                new RatingEntity(idSequence, rating.date(), rating.user(), rating.beer(), rating.rate())
        );
    }

    @PostConstruct
    private void postConstruct() {
        this.save(new Rating("beer1", "user1", 5));
    }
}
