package ru.boris.demo.tg.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.CommandInvoker;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.command.DesignPrincipalLeftCommand;
import ru.boris.demo.tg.bot.command.DesignPrincipalRightCommand;
import ru.boris.demo.tg.bot.command.DesignPrinciplesCommand;
import ru.boris.demo.tg.bot.command.StartCommand;
import ru.boris.demo.tg.bot.dto.CommandType;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommandInitializer {

    private final TgBot bot;
    private final CommandInvoker commandInvoker;
    private final Map<String, TgMessageService> tgMessageService;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        commandInvoker.setCommand(CommandType.START, new StartCommand(bot));

        TgMessageService designPrinciplesTgMessageService = tgMessageService.get("designPrinciplesTgMessageService");
        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPLE, new DesignPrinciplesCommand(
                bot, designPrinciplesTgMessageService));

        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPAL_RIGHT, new DesignPrincipalRightCommand(
                bot, designPrinciplesTgMessageService));

        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPAL_LEFT, new DesignPrincipalLeftCommand(
                bot, designPrinciplesTgMessageService));
    }
}
