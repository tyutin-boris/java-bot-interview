package ru.boris.demo.tg.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.service.TgBotService;

@Service
@RequiredArgsConstructor
public class TgBotServiceImpl implements TgBotService {

    private final TgBot bot;

    @Override
    public void send(SendMessage message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Ошибка при отправке сообщения", e);
        }
    }

    @Override
    public void send(EditMessageText message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Ошибка при отправке сообщения", e);
        }
    }
}
