package ru.boris.demo.tg.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.boris.demo.tg.bot.bot.TgBot;

@Component
@RequiredArgsConstructor
public class BotInitializer {

    private final TgBot tgBot;

    @EventListener(ContextRefreshedEvent.class)
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(tgBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Не удалось зарегистрировать бота", e);
        }
    }
}
