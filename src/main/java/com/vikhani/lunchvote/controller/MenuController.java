package com.vikhani.lunchvote.controller;

import com.vikhani.lunchvote.AuthUser;
import com.vikhani.lunchvote.to.MenuTo;
import com.vikhani.lunchvote.model.Menu;
import com.vikhani.lunchvote.util.MenuUtil;
import com.vikhani.lunchvote.repository.MenuRepository;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import lombok.AllArgsConstructor;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(value = MenuController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MenuController {
    public static final String REST_URL = "/api/menus";

    protected final Logger log = getLogger(getClass());

    protected MenuRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Menu> addMenu(@RequestBody MenuTo menuTo, @AuthenticationPrincipal AuthUser user) {
        log.info("add menu {} by {}", menuTo, user);

        Menu created = repository.save(new Menu(menuTo.getDatetime(), menuTo.getRestaurantName(), MenuUtil.createMealsFromMenuTo(menuTo)));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<MenuTo> getMenus(@AuthenticationPrincipal AuthUser user) {
        log.info("get all menus {}", user);

        return MenuUtil.createMenuToToFromMenus(repository.findAll());
    }
}

