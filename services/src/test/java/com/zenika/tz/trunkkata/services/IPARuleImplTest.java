package com.zenika.tz.trunkkata.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IPARuleImplTest {

    private IPARule ipaRule;

    @BeforeEach
    public void setUp() {
        this.ipaRule = new IPARule();
    }

    @ParameterizedTest
    @MethodSource ("tripleIPA")
    void shouldBeATripleIPA(Integer ibu, Double alcool) {
        String res = ipaRule.determineIPAType(alcool, ibu);

        Assertions.assertThat(res)
                .isEqualTo("Triple IPA");
    }

    @ParameterizedTest
    @MethodSource ("doubleIPA")
    void shouldBeADoubleIPA(Integer ibu, Double alcool) {
        String res = ipaRule.determineIPAType(alcool, ibu);

        Assertions.assertThat(res)
                .isEqualTo("Double IPA");
    }

    @ParameterizedTest
    @MethodSource ("simpleIPA")
    void shouldBeAnIPA(Integer ibu, Double alcool) {
        String res = ipaRule.determineIPAType(alcool, ibu);

        Assertions.assertThat(res)
                .isEqualTo("IPA");
    }

    static Stream<Arguments> tripleIPA() {
        int minIbu = 100;
        int maxIbu = 150;
        int minAlcool = 10;
        int maxAlcool = 15;

        return getArgumentsStream(minIbu, maxIbu, minAlcool, maxAlcool);
    }

    static Stream<Arguments> doubleIPA() {
        int minIbu = 60;
        int maxIbu = 120;
        int minAlcool = 7;
        int maxAlcool = 10;

        return getArgumentsStream(minIbu, maxIbu, minAlcool, maxAlcool);
    }

    static Stream<Arguments> simpleIPA() {
        int minIbu = 40;
        int maxIbu = 80;
        int minAlcool = 5;
        int maxAlcool = 7;

        return getArgumentsStream(minIbu, maxIbu, minAlcool, maxAlcool);
    }

    private static Stream<Arguments> getArgumentsStream(final int minIbu, final int maxIbu, final int minAlcool, final int maxAlcool) {
        List<Arguments> listOfArguments = new LinkedList<>();
        List<Integer> alcools = IntStream.range(minAlcool, maxAlcool).boxed().toList();
        IntStream.range(minIbu, maxIbu)
                .forEach(ibu -> {
                    alcools.forEach(a -> {
                        listOfArguments.add(Arguments.of(ibu, Double.valueOf(a)));
                    });
                });
        return listOfArguments.stream();
    }

}