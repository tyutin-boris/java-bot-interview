package ru.boris.demo.tg.bot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.boris.demo.tg.bot.api.command.CommandInvoker;
import ru.boris.demo.tg.bot.api.service.EditMessageTextService;
import ru.boris.demo.tg.bot.api.service.SendMessageService;
import ru.boris.demo.tg.bot.api.service.TgBotService;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.api.service.UpdateService;
import ru.boris.demo.tg.bot.command.DesignPrincipalLeftCommand;
import ru.boris.demo.tg.bot.command.DesignPrincipalRightCommand;
import ru.boris.demo.tg.bot.command.DesignPrinciplesCommand;
import ru.boris.demo.tg.bot.command.StartCommand;
import ru.boris.demo.tg.bot.dto.CommandType;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

@Component
@RequiredArgsConstructor
public class CommandInitializer {

    private final CommandInvoker commandInvoker;
    private final TgBotService tgBotService;
    private final UpdateService updateService;
    private final SendMessageService sendMessageService;
    private final EditMessageTextService editMessageTextService;
    private final TgMessageService<DesignPrinciplesMessage> designPrinciplesTgMessageService;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        commandInvoker.setCommand(CommandType.START, new StartCommand(tgBotService, updateService, sendMessageService));

        DesignPrinciplesCommand designPrinciplesCommand = new DesignPrinciplesCommand(
                tgBotService,
                sendMessageService,
                designPrinciplesTgMessageService);
        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPLE, designPrinciplesCommand);

        DesignPrincipalRightCommand principalRightCommand = new DesignPrincipalRightCommand(
                tgBotService,
                editMessageTextService,
                designPrinciplesTgMessageService);
        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPAL_RIGHT, principalRightCommand);

        DesignPrincipalLeftCommand principalLeftCommand = new DesignPrincipalLeftCommand(
                tgBotService,
                editMessageTextService,
                designPrinciplesTgMessageService);
        commandInvoker.setCommand(CommandType.DESIGN_PRINCIPAL_LEFT, principalLeftCommand);
    }
}
