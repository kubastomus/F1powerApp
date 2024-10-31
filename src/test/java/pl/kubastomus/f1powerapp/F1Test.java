package pl.kubastomus.f1powerapp;

import org.junit.jupiter.api.Test;
import pl.kubastomus.formula.ergast.Ergast;


import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class F1Test {

    @Test
    void shouldTwoObjectBeTheSame() {
        //given
        Ergast e1 = new Ergast();
        Ergast e2 = e1;
        //then
        assertSame(e1, e2);
        assertThat(e1).isEqualTo(e2);
    }

    @Test
    void shouldTwoObjectNotBeTheSame() {
        //given
        Ergast e1 = new Ergast();
        Ergast e2 = new Ergast();
        //then
        assertNotSame(e1, e2);
        assertThat(e1).isNotEqualTo(e2);
    }



    @Test
    void shouldReturnDriversOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2006, 50, Ergast.DEFAULT_OFFSET);
        ergast.getDrivers().forEach(System.out::println);
//        ergast.getSchedules().forEach(System.out::println); // testowy przykład
    }

    @Test
    void shouldReturnConstructorsOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2020, 50, Ergast.DEFAULT_OFFSET);
        ergast.getConstructors().forEach(System.out::println);
    }

    @Test
    void shouldReturnRaceResultOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2018, 50, Ergast.DEFAULT_OFFSET);
        ergast.getDriverStandings(1).forEach(System.out::println);
    }

}
