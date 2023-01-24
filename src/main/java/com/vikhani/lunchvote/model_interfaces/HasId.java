package com.vikhani.lunchvote.model_interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;

import java.util.Objects;

public interface HasId {
    Integer getId();

    void setId(Integer id);

    @JsonIgnore
    default boolean isNew() {
        return Objects.isNull(getId());
    }

    default int id() {
        Assert.notNull(getId(), "Entity must has id");
        return getId();
    }
}
