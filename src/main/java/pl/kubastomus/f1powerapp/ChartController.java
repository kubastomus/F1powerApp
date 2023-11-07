package pl.kubastomus.f1powerapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kodujmy.formula.ergast.Ergast;
import pl.kodujmy.formula.ergast.objects.RaceResult;
import pl.kodujmy.formula.ergast.objects.Schedule;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ChartController {

    private Ergast ergastCharts = new Ergast();

    @GetMapping("/chart")
    public String getChartExample(Model model) {
        List<Integer> data = Arrays.asList(10, 20, 30, 40, 50);
        List<String> labels = Arrays.asList("A", "B", "C", "D", "E");
        model.addAttribute("data", data);
        model.addAttribute("labels", labels);
        return "chart";
    }

    @GetMapping("/{idSeason}/drivers/{driverId}/results")
    public String getDriverResultsOnChart (@PathVariable Integer idSeason, @PathVariable String driverId, Model model) throws IOException {
        List<String> labels = new ArrayList<>();
        List<Integer> places = new ArrayList<>();
        ergastCharts.setSeason(idSeason);
        List<Schedule> scheduleList = ergastCharts.getSchedules();


//        for (int i = 0; i < scheduleList.size(); i++){
//            int seasonSize = i;
//            List<DriverStandings> driverStandingsList = ergastCharts.getDriverStandings(i + 1);
//
//            for (DriverStandings finish : driverStandingsList){
//                if (finish.getDriver().getDriverId().equals(driverId)) {
//                    labels.add(scheduleList.get(i).getRaceName()); // add the race name as the label
//                    places.add(finish.getPosition()); // add the driver's position in the race
//                }
//            }
//        }


        for (int i = 0; i < scheduleList.size(); i++){
            int seasonSize = i + 1;
            List<RaceResult> raceResultList = ergastCharts.getRaceResults(scheduleList.get(i).getRound());

            for (RaceResult raceResult : raceResultList){
                if (raceResult.getDriver().getDriverId().equals(driverId)) {
                    labels.add(scheduleList.get(i).getRaceName()); // add the race name as the label
                    places.add(raceResult.getPosition()); // add the driver's position in the race
                    break; // break out of the loop once the driver's result has been found
                }
            }
        }

        model.addAttribute("labels", labels);
        model.addAttribute("places", places);

        return "driver-results";
    }

}
