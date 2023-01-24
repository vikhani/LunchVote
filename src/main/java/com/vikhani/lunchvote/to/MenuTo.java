package com.vikhani.lunchvote.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Value
@EqualsAndHashCode(callSuper = true)
public class MenuTo extends BaseTo {
    @NotNull
    LocalDateTime datetime;

    @NotBlank
    @Length(min = 2, max = 128)
    String restaurantName;

    Set<MealTo> meals;

    public MenuTo(Integer id, LocalDateTime dateTime, String restaurantName, Collection<MealTo> meals) {
        super(id);
        this.datetime = dateTime;
        this.restaurantName = restaurantName;
        this.meals = new HashSet<>(meals);
    }
}
