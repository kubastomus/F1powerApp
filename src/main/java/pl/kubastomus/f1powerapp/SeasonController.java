package pl.kubastomus.f1powerapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.olerom.formula.ergast.Ergast;
import ru.olerom.formula.ergast.objects.DriverStandings;
import ru.olerom.formula.ergast.objects.RaceResult;
import ru.olerom.formula.ergast.objects.Schedule;
import ru.olerom.formula.ergast.objects.Season;
import java.io.IOException;
import java.util.List;

@Controller
public class SeasonController {

    private Ergast ergastContr = new Ergast();

    @RequestMapping
    public String getSeasons(Model model) throws IOException {

        Ergast ergastSeasons = new Ergast();
        List<Season> seasons = ergastSeasons.getSeasons();
        model.addAttribute("seasons", seasons);

        return "index";
    }

    @RequestMapping("/{idSeason}")
    public String getSeason(@PathVariable Integer idSeason, Model model) throws IOException {
        ergastContr.setSeason(idSeason);
        List<Schedule> scheduleList = ergastContr.getSchedules();
        model.addAttribute("season", scheduleList);

        return "seasonSchedule";
    }

    @RequestMapping("/{idSeason}/{roundRace}/results")
    public String getRaceResult(@PathVariable Integer idSeason, @PathVariable Integer roundRace, Model model) throws IOException {
        ergastContr.setSeason(idSeason);
        List<RaceResult> raceResultList = ergastContr.getRaceResults(roundRace);
        model.addAttribute("raceResult", raceResultList);

        return "raceResults";
    }
}
