package ru.boris.demo.tg.bot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum CallbackQueryType {
    DESIGN_PRINCIPAL_LEFT("design_principal_left_button", "Обратно"),
    DESIGN_PRINCIPAL_RIGHT("design_principal_right_button", "Туда");

    private final String name;
    private final String text;

    public static Optional<CallbackQueryType> getByName(String name) {
        for (CallbackQueryType value : CallbackQueryType.values()) {
            if (value.name.equals(name)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
