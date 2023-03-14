package com.exam.telegrambot1.components;

import com.exam.telegrambot1.entity.BookEntity;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    List<BotCommand> LIST_OF_COMMANDS = List.of(
            new BotCommand("/start","включить бота"),
            new BotCommand("/help","что бот умеет"),
            new BotCommand("/all","показать список книг")
    );

    String HELP_TEXT = "Вам доступны следующие команды:\n\n" +
            "/start - включить бота\n" +
            "/help - меню помощи\n"+
            "/all - показать список книг\n";
}
