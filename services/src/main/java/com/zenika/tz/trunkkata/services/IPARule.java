package com.zenika.tz.trunkkata.services;

import org.springframework.stereotype.Component;

@Component
public class IPARule {

    public String determineIPAType(final Double alcool, final Integer ibu) {
        if (alcool >= 10 && (ibu >= 100)) {
            return "Triple IPA";
        }
        if (alcool < 7 && ibu <= 80) {
            return "IPA";
        }
        return "Double IPA";
    }
}
