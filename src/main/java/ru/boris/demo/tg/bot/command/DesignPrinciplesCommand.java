package ru.boris.demo.tg.bot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.message.TgMessage;
import ru.boris.demo.tg.bot.api.service.SendMessageService;
import ru.boris.demo.tg.bot.api.service.TgBotService;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

import static ru.boris.demo.tg.bot.dto.CommandType.DESIGN_PRINCIPLE;

@Service
@RequiredArgsConstructor
public class DesignPrinciplesCommand implements Command {

    private final TgBotService tgBotService;
    private final SendMessageService sendMessageService;
    private final TgMessageService<DesignPrinciplesMessage> designPrinciplesTgMessageService;

    @Override
    public void execute(Update update) {
        TgMessage tgMessage = designPrinciplesTgMessageService.getTgMessage(update);
        SendMessage sendMessage = sendMessageService.getSendMessage(tgMessage);
        tgBotService.send(sendMessage);
    }

    @Override
    public CommandType getCommandType() {
        return DESIGN_PRINCIPLE;
    }
}
