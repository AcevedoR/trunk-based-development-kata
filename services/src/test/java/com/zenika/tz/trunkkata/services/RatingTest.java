package com.zenika.tz.trunkkata.services;

import com.zenika.tz.trunkkata.domain.Rating;
import com.zenika.tz.trunkkata.utils.PersistenceFunctionMock;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RatingTest {
    @ParameterizedTest
    @EmptySource
    void shouldNot_instanciate_withMissingBeer(String beer) {
        assertThatThrownBy(() -> new Rating(beer, "userx", 1))
                .hasMessageContaining("beer");
    }

    @ParameterizedTest
    @EmptySource
    void shouldNot_instanciate_withMissingUser(String user) {
        assertThatThrownBy(() -> new Rating("beerx", user, 1))
                .hasMessageContaining("user");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 6, 10, 99, 34343})
    void shouldNot_instanciate_withOutOfRangeRate(Integer rate) {
        assertThatThrownBy(() -> new Rating("beerx", "userx", rate))
                .hasMessageContaining("rate");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void should_instanciate_withValidRate(Integer rate) {
        assertThatCode(() -> new Rating("beerx", "userx", rate)).doesNotThrowAnyException();
    }

    @Test
    void should_create(){
        // given
        Rating rating = new Rating("beerx", "userx", 1);
        PersistenceFunctionMock<Rating> ratingPersistenceFunctionMock = new PersistenceFunctionMock<>();
        Consumer<Rating> persistFunction = ratingPersistenceFunctionMock::apply;

        // when
        assertThatCode(() -> rating.create(persistFunction)).doesNotThrowAnyException();
        assertThat(ratingPersistenceFunctionMock.getCallCount()).isEqualTo(1);
    }
}
