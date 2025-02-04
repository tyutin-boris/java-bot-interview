package ru.boris.demo.tg.bot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum BotCommands {

    START("/start", "Начало диалога"),

    DESIGN_PRINCIPLES("/show_design_principles", "Показать принципы проектирования");

    private final String name;
    private final String description;

    public static Optional<BotCommands> getCommandsByName(String name) {

        for (BotCommands value : BotCommands.values()) {
            if (value.name.equals(name)) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }
}
