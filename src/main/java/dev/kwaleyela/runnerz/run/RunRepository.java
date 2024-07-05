package dev.kwaleyela.runnerz.run;

import java.util.List;
import java.util.Optional;

public interface RunRepository {
    public List<Run> findAll();

    public Optional<Run> findById(Integer id);

    public void create(Run run);

    public void update(Run run, Integer id);

    public void delete(Integer id);

    public int count();

    public void saveAll(List<Run> runs);

    public List<Run> findByLocation(String location);
}
