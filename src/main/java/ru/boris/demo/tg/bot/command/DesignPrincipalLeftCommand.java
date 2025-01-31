package ru.boris.demo.tg.bot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.service.EditMessageTextService;
import ru.boris.demo.tg.bot.api.service.TgBotService;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

@Service
@RequiredArgsConstructor
public class DesignPrincipalLeftCommand implements Command {

    private final TgBotService tgBotService;
    private final EditMessageTextService editMessageTextService;
    private final TgMessageService<DesignPrinciplesMessage> messageService;

    @Override
    public void execute(Update update) {
        DesignPrinciplesMessage tgMessage = messageService.getTgMessage(update);
        tgMessage.previous();
        EditMessageText response = editMessageTextService.getEditMessageText(tgMessage);
        tgBotService.send(response);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DESIGN_PRINCIPAL_LEFT;
    }
}
