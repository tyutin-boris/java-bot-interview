package ru.boris.demo.tg.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.boris.demo.tg.bot.dto.BotCommands;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BotCommandConfig {

    @Bean
    public List<BotCommand> botCommands() {
        List<BotCommands> commands = Arrays.stream(BotCommands.values()).toList();
        return createCommands(commands);
    }

    private List<BotCommand> createCommands(List<BotCommands> commands) {
        return commands.stream()
                .map(c -> new BotCommand(c.getName(), c.getDescription()))
                .toList();
    }
}
