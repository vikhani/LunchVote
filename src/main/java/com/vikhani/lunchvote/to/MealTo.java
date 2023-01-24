package com.vikhani.lunchvote.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Value
@EqualsAndHashCode(callSuper = true)
public class MealTo extends BaseTo {
    @NotBlank
    @Size(min = 2, max = 128)
    String name;

    @NotNull
    @Range(min = 1, max = 10000)
    BigDecimal price;
}
