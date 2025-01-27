package ru.boris.demo.tg.bot.api.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateService {

    Long getChatId(Update update);

    Integer getMessageId(Update update);
}
