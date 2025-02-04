package ru.boris.demo.tg.bot.dto;

/**
 * Типы команд.
 */
public enum CommandType {
    /**
     * Команда приветствия.
     */
    START,

    /**
     * Команда отображает принципы проектирования.
     */
    DESIGN_PRINCIPLE,

    /**
     * Кнопка в лево, для смены принципов проектирования.
     */
    DESIGN_PRINCIPAL_LEFT,

    /**
     * Кнопка в право, для смены принципов проектирования.
     */
    DESIGN_PRINCIPAL_RIGHT
}
