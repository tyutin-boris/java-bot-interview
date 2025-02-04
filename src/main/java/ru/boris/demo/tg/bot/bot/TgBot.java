package ru.boris.demo.tg.bot.bot;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.boris.demo.tg.bot.api.command.CommandInvoker;
import ru.boris.demo.tg.bot.config.TgBotProperty;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TgBot extends TelegramLongPollingBot {

    private final List<BotCommand> botCommands;

    private final CommandInvoker commandInvoker;

    private final TgBotProperty tgBotProperty;

    @PostConstruct
    private void setUp() {
        try {
            String languageCode = null;
            BotCommandScopeDefault scope = new BotCommandScopeDefault();
            SetMyCommands method = new SetMyCommands(botCommands, scope, languageCode);

            execute(method);
            log.info("Добавлены команды для бота: " + botCommands);
        } catch (TelegramApiException e) {
            log.error("Не удалось добавить команды", e);
        }
    }

    @Override
    public String getBotUsername() {
        return tgBotProperty.getUsername();
    }

    @Override
    public String getBotToken() {
        return tgBotProperty.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Received update: {}", update);
        commandInvoker.execute(update);
    }
}
