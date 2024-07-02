package dev.kwaleyela.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    
    private List<Run> runs = new ArrayList<>();

    @PostConstruct
    public void init() {
        runs.add(new Run(
            1,
            "Monday Morning Run",
            LocalDateTime.now(),
            LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
            3,
            Location.INDOOR
        ));

        runs.add(new Run(
            1,
            "Tuesday Morning Run",
            LocalDateTime.now(),
            LocalDateTime.now().plus(40, ChronoUnit.MINUTES),
            4,
            Location.INDOOR
        ));
    }

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    public void createRun(Run run) {
        runs.add(run);
    }

    public void updateRun(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }
}
