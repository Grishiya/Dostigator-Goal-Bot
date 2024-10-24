package com.achievements.bot.pomogator_goals.config;

import com.achievements.bot.pomogator_goals.controller.DostigatorGoalBot;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {

    @Autowired
    private DostigatorGoalBot goalAchieverBot;

    @PostConstruct
    public void registerBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(goalAchieverBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}