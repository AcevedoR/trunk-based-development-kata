package com.zenika.tz.trunkkata.domain.request;

public record CreateBeerRequest(String name, String brewery, Double alcool, Integer ibu) {
}