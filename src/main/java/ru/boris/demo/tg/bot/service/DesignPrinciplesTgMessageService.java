package ru.boris.demo.tg.bot.service;

import org.springframework.stereotype.Service;
import ru.boris.demo.tg.bot.api.service.TgMessageService;
import ru.boris.demo.tg.bot.message.DesignPrinciplesMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DesignPrinciplesTgMessageService implements TgMessageService {

    private final Map<Long, DesignPrinciplesMessage> messages = new HashMap<>();

    @Override
    public DesignPrinciplesMessage getTgMessage(Long id, Integer messageId) {
        Optional<DesignPrinciplesMessage> message = Optional.ofNullable(messages.get(id));

        if (message.isPresent()) {
            return message.get();
        }

        DesignPrinciplesMessage designPrinciplesMessage = new DesignPrinciplesMessage(id, messageId);
        messages.put(id, designPrinciplesMessage);
        return designPrinciplesMessage;
    }
}
