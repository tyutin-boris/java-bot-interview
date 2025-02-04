package ru.boris.demo.tg.bot.api.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.boris.demo.tg.bot.api.message.TgMessage;

public interface SendMessageService {

    SendMessage getSendMessage(TgMessage tgMessage);

    SendMessage getSendMessage(Long chatId, String text);
}
