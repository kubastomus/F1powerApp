package pl.kubastomus.f1powerapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kubastomus.formula.ergast.Ergast;
import pl.kubastomus.formula.ergast.objects.RaceResult;
import pl.kubastomus.formula.ergast.objects.Schedule;

import java.io.IOException;
import java.util.List;


@Controller
public class SeasonController {

    private Ergast ergastContr = new Ergast();

//    @RequestMapping("/")
//    public String getSeasons(Model model) throws IOException {
//
//        Ergast ergastSeasons = new Ergast();
//        List<Season> seasons = ergastSeasons.getSeasons();
//        model.addAttribute("seasons", seasons);
//
//        return "index";
//    }



        @GetMapping("/")// zamieniona strona startowa na formularz wyboru sezonu
    public String getHomePage(Model model) throws IOException {
        model.addAttribute("emptySeason", new SeasonDTO());

        return "index2";
    }

    @PostMapping("/{idSeason}")
    public String postHomePage(@ModelAttribute("emptySeason") SeasonDTO seasonDTO, Model model) throws IOException {
        ergastContr.setSeason(seasonDTO.getIdSeason());
        List<Schedule> scheduleList = ergastContr.getSchedules();
        model.addAttribute("season", scheduleList);

        return "seasonSchedule";
    }

    @GetMapping("/{idSeason}")
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
