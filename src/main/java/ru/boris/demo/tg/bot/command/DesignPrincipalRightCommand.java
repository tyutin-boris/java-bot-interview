package ru.boris.demo.tg.bot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

import java.util.Optional;

public class DesignPrincipalRightCommand implements Command {

    private final TgBot bot;
    private final TgMessageService messageService;

    public DesignPrincipalRightCommand(TgBot bot, TgMessageService messageService) {
        this.bot = bot;
        this.messageService = messageService;
    }

    @Override
    public void execute(Update update) {
        Optional<MaybeInaccessibleMessage> message = Optional.ofNullable(update)
                .map(Update::getCallbackQuery)
                .map(CallbackQuery::getMessage);

        Optional<Long> chatId = message.map(MaybeInaccessibleMessage::getChatId);
        Optional<Integer> messageId = message.map(MaybeInaccessibleMessage::getMessageId);
        if (chatId.isPresent() && messageId.isPresent()) {

            DesignPrinciplesMessage tgMessage = (DesignPrinciplesMessage) messageService
                    .getTgMessage(chatId.get(), messageId.get());

            SendMessage method = new SendMessage();



//            bot.execute(method);
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DESIGN_PRINCIPAL_RIGHT;
    }
}
