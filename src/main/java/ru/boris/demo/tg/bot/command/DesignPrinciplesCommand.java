package ru.boris.demo.tg.bot.command;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.boris.demo.tg.bot.TgBot;
import ru.boris.demo.tg.bot.api.command.Command;
import ru.boris.demo.tg.bot.api.message.TgMessage;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.dto.CommandType;

import java.util.Optional;

import static ru.boris.demo.tg.bot.dto.CommandType.DESIGN_PRINCIPLE;

@RequiredArgsConstructor
public class DesignPrinciplesCommand implements Command {

    private final TgBot bot;
    private final TgMessageService designPrinciplesTgMessageService;

    @Override
    public void execute(Update update) {
        Optional<Message> message = Optional.ofNullable(update)
                .map(Update::getMessage);

        Optional<Long> chatId = message.map(Message::getChatId);
        Optional<Integer> messageId = message.map(Message::getMessageId);

        if (chatId.isPresent() && messageId.isPresent()) {
            TgMessage tgMessage = designPrinciplesTgMessageService
                    .getTgMessage(chatId.get(), messageId.get());
            SendMessage sendMessage = getSendMessage(chatId.get(), tgMessage);
            execute(sendMessage);
        }
    }

    @Override
    public CommandType getCommandType() {
        return DESIGN_PRINCIPLE;
    }

    private SendMessage getSendMessage(Long chatId, TgMessage tgMessage) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(tgMessage.getText());
        message.setReplyMarkup(tgMessage.getInlineKeyboardMarkup());

        return message;
    }

    private void execute(SendMessage method) {
        try {
            bot.execute(method);
        } catch (TelegramApiException e) {
            throw new RuntimeException("Ошибка при отправке сообщения", e);
        }
    }
}
