package com.vikhani.lunchvote.util;

import com.vikhani.lunchvote.model.Meal;
import com.vikhani.lunchvote.model.Menu;
import com.vikhani.lunchvote.to.MealTo;
import com.vikhani.lunchvote.to.MenuTo;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@UtilityClass
public class MenuUtil {
    public Meal createMealFromMealTo(MealTo mealTo) {
        return new Meal(mealTo.getName(), mealTo.getPrice());
    }

    public MealTo createMealToFromMeal(Meal meal) {
        return new MealTo(meal.getName(), meal.getPrice());
    }


    public MenuTo createMenuToFromMenu(Menu menu) {
        return new MenuTo(menu.getId(), menu.getDatetime(), menu.getRestaurantName(), createMealsToFromMeals(menu.getMeals().stream().toList()));
    }

    public List<MealTo> createMealsToFromMeals(List<Meal> meals) {
        return meals.stream()
                .map(MenuUtil::createMealToFromMeal)
                .toList();
    }

    public List<MenuTo> createMenuToToFromMenus(List<Menu> menus) {
        return menus.stream()
                .map(MenuUtil::createMenuToFromMenu)
                .toList();
    }

    public Set<Meal> createMealsFromMenuTo(MenuTo menuTo) {
        if (menuTo.getMeals().isEmpty()) {
            return Collections.emptySet();
        }

        return menuTo.getMeals().stream()
                .map(MenuUtil::createMealFromMealTo)
                .collect(Collectors.toSet());
    }
}
