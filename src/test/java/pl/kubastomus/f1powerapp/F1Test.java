package pl.kubastomus.f1powerapp;

import org.junit.jupiter.api.Test;
import ru.olerom.formula.ergast.Ergast;

import java.io.IOException;

public class F1Test {

    @Test
    public void shouldReturnDriversOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2006, 50, Ergast.DEFAULT_OFFSET);
        ergast.getDrivers().forEach(System.out::println);
//        ergast.getSchedules().forEach(System.out::println); // testowy przykład
    }

    @Test
    public void shouldReturnConstructorsOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2020, 50, Ergast.DEFAULT_OFFSET);
        ergast.getConstructors().forEach(System.out::println);
    }

    @Test
    public void shouldReturnRaceResultOfExampleSeason() throws IOException {

        Ergast ergast = new Ergast(2018, 50, Ergast.DEFAULT_OFFSET);
        ergast.getDriverStandings(1).forEach(System.out::println);
    }

}
