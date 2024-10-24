package com.achievements.bot.pomogator_goals.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
@Component
public class DostigatorGoalBot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String botName;

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            if (messageText.equals("/start")) {
                String responseText = "Здравствуйте! 👋 Я бот \"Достигатор целей\". "
                        + "Моя задача — помочь вам ставить цели и успешно достигать их. "
                        + "Я буду сопровождать вас на каждом шагу, отслеживая прогресс и предоставляя мотивацию. "
                        + "Готовы начать свой путь к успеху? 🚀";
                SendMessage message = new SendMessage();
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(responseText);

                try {
                    execute(message); // Отправляем сообщение пользователю
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
