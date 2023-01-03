package com.shabatura.module3.service;

import lombok.Getter;

@Getter
public enum ActionsMenu {
    SEARCH_SMS_BY_PHRASE ("Search through SMS by phrase"),
    TOP5_ABONENTS_BY_CALLS ("TOP5 subscribers by calls"),
    TOP5_ABONENTS_BY_SMS ("TOP5 subscribers by SMS"),
    TOP5_ABONENTS_BY_INTERNET ("TOP5 subscribers by Internet requests"),
    MOST_POPULAR_SERVICE ("Most popular service"),
    MOST_POPULAR_DEVICE ("Most popular device"),
    EXIT ("Exit");

    private final String name;
    ActionsMenu(String name) {
        this.name = name;
    }

}
