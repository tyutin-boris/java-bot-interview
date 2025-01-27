package ru.boris.demo.tg.bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.api.service.UpdateService;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesignPrinciplesTgMessageService implements TgMessageService<DesignPrinciplesMessage> {

    private final UpdateService updateService;
    private final Map<Long, DesignPrinciplesMessage> messages = new HashMap<>();

    @Override
    public DesignPrinciplesMessage getTgMessage(Update update) {
        Long chatId = updateService.getChatId(update);
        Integer messageId = updateService.getMessageId(update);
        Optional<DesignPrinciplesMessage> message = Optional.ofNullable(messages.get(chatId));

        if (message.isPresent()) {
            return message.get();
        }

        DesignPrinciplesMessage designPrinciplesMessage = new DesignPrinciplesMessage(chatId, messageId);
        messages.put(chatId, designPrinciplesMessage);
        return designPrinciplesMessage;
    }
}
