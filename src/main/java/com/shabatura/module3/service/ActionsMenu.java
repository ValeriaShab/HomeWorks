package com.shabatura.module3.service;

import lombok.Getter;

@Getter
public enum ActionsMenu {
    SEARCH_SMS_BY_PHRASE ("Поиск в сообщениях по кодовому слову"),
    TOP5_ABONENTS_BY_CALLS ("TOP5 абонентов по вызовам"),
    TOP5_ABONENTS_BY_SMS ("TOP5 абонентов по СМС"),
    TOP5_ABONENTS_BY_INTERNET ("TOP5 абонентов по использованию сети"),
    MOST_POPULAR_SERVICE ("Самый популярный сервис"),
    MOST_POPULAR_DEVICE ("Самый популярный девайс"),
    EXIT ("Выход");

    private final String name;
    ActionsMenu(String name) {
        this.name = name;
    }

}
