package com.vikhani.lunchvote.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Set;
import java.time.LocalDateTime;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {
    @CreationTimestamp
    @Column(name = "date_time", nullable = false)
    private LocalDateTime datetime;

    @CollectionTable(name = "menu_restaurant",
            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "restaurant_name"}, name = "uk_menu_restaurant"))
    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "meal")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  // TODO fetch type ???
    private Set<Meal> meals;

    public Menu(Integer id, LocalDateTime datetime, String restaurantName, Set<Meal> meals) {
        super(id);
        this.datetime = datetime;
        this.restaurantName = restaurantName;
        this.meals = meals;
    }
    public Menu(LocalDateTime datetime, String restaurantName, Set<Meal> meals) {
        this(null, datetime, restaurantName, meals);
    }
}
