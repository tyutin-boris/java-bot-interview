package ru.boris.demo.tg.bot.api.service;

import ru.boris.demo.tg.bot.api.message.TgMessage;

public interface TgMessageService {

    TgMessage getTgMessage(Long id, Integer messageId);
}
