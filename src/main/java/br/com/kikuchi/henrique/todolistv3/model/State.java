package br.com.kikuchi.henrique.todolistv3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum State {
    @JsonProperty("created")
    CREATED("created"),
    @JsonProperty("readToWork")
    READY_TO_WORK("readToWork"),
    @JsonProperty("waitingForInfo")
    WAITING_FOR_INFO("waitingForInfo"),
    @JsonProperty("completed")
    COMPLETED("completed"),
    @JsonProperty("blocked")
    BLOCKED("blocked");

    private final String description;

    State (String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
