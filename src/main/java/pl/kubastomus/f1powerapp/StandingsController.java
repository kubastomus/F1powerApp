package pl.kubastomus.f1powerapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kubastomus.formula.ergast.Ergast;
import pl.kubastomus.formula.ergast.objects.ConstructorStandings;
import pl.kubastomus.formula.ergast.objects.DriverStandings;

import java.io.IOException;
import java.util.List;

@Controller
public class StandingsController {

    private Ergast ergastStandings = new Ergast();

    @RequestMapping("/{idSeason}/{roundRace}/driverStandings")
    public String getDriverStandingsAfterRace(@PathVariable Integer idSeason,
                                              @PathVariable Integer roundRace, Model model) throws IOException {
        ergastStandings.setSeason(idSeason);
        List<DriverStandings> driverStandingsAfterRace = ergastStandings.getDriverStandings(roundRace);
        model.addAttribute("driverStandings", driverStandingsAfterRace);

        return "driverStandings";
    }

    @RequestMapping("/{idSeason}/{roundRace}/constructorStandings")
    public String getConstructorStandingsAfterRace(@PathVariable Integer idSeason,
                                                   @PathVariable Integer roundRace, Model model) throws IOException {
        ergastStandings.setSeason(idSeason);
        List<ConstructorStandings> constructorStandingsAfterRace = ergastStandings.getConstructorStandings(roundRace);
        model.addAttribute("constructorStandings", constructorStandingsAfterRace);

        return "constructorStandings";
    }

}
