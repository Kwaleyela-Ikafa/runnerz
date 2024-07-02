package dev.kwaleyela.runnerz.run;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    @Past
    LocalDateTime startedOn,
    @Future
    LocalDateTime completedOn,
    @Positive
    Integer miles,
    Location location
) {}
