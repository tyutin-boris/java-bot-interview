package ru.boris.demo.tg.bot.command;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

import java.util.Optional;

public class DesignPrincipalLeftCommand implements Command {

    private final TgBot bot;
    private final TgMessageService messageService;

    public DesignPrincipalLeftCommand(TgBot bot, TgMessageService messageService) {
        this.bot = bot;
        this.messageService = messageService;
    }

    @Override
    public void execute(Update update) {
        Optional<MaybeInaccessibleMessage> message = Optional.ofNullable(update)
                .map(Update::getCallbackQuery)
                .map(CallbackQuery::getMessage);

        Optional<Long> chatIdOpt = message.map(MaybeInaccessibleMessage::getChatId);
        Optional<Integer> messageIdOpt = message.map(MaybeInaccessibleMessage::getMessageId);
        if (chatIdOpt.isPresent() && messageIdOpt.isPresent()) {
            Long chatId = chatIdOpt.get();
            Integer messageId = messageIdOpt.get();

            DesignPrinciplesMessage tgMessage = (DesignPrinciplesMessage) messageService
                    .getTgMessage(chatId, messageId);
            String text = tgMessage.prev();
            InlineKeyboardMarkup inlineKeyboardMarkup = tgMessage.getInlineKeyboardMarkup();

            EditMessageText response = new EditMessageText();
            response.setChatId(chatId);
            response.setMessageId(messageId);
            response.setText(text);
            response.setReplyMarkup(inlineKeyboardMarkup);

            try {
                bot.execute(response);
            } catch (TelegramApiException e) {
                throw new RuntimeException("Не удалось обновить сообщение", e);
            }
        }
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.DESIGN_PRINCIPAL_LEFT;
    }
}
