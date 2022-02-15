package com.zenika.tz.trunkkata.entity;

import java.time.LocalDateTime;

public record RatingEntity(Long id, LocalDateTime date, String user, String beer, int rate) {
}
