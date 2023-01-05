package com.vikhani.lunchvote.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {
    @Column(name = "date_time", nullable = false)
    private LocalDateTime datetime;

    @CollectionTable(name = "menu_restaurant",
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "restaurant_name"}, name = "uk_menu_restaurant"))
    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "meal")
    @OneToMany
    private Set<Meal> meals;
}
