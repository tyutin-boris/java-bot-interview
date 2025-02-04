package ru.boris.demo.tg.bot.api.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public interface TgBotService {

    void send(SendMessage message);

    void send(EditMessageText message);
}
