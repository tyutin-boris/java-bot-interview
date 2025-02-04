package ru.boris.demo.tg.bot.api.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.message.TgMessage;

public interface TgMessageService<T extends TgMessage> {

    T getTgMessage(Update update);
}
