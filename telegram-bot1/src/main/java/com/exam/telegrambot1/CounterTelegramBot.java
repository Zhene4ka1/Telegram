package com.exam.telegrambot1;

import com.exam.telegrambot1.components.BotCommands;
import com.exam.telegrambot1.components.Buttons;
import com.exam.telegrambot1.config.BotConfig;
import com.exam.telegrambot1.entity.BookEntity;
import com.exam.telegrambot1.response.BookListResponse;
import com.exam.telegrambot1.response.BookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.validation.constraints.NotNull;

@Slf4j
@Component
public class CounterTelegramBot extends TelegramLongPollingBot implements BotCommands {

    final BotConfig config;
    public CounterTelegramBot(BotConfig config) { this.config = config;
    try {
        this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(),null));
    }catch (TelegramApiException e){
        log.error(e.getMessage());
    }
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public void onUpdateReceived(@NotNull Update update) {
        if (update.hasMessage()&&update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getFrom().getFirstName();
            String receivedMessage = update.getMessage().getText();
            String[] num =receivedMessage.split(" ");
            switch (num[0]) {

                case "/start":
                    startBot(chatId, userName);
                    break;
                case "/help":
                    sendHelpText(chatId, HELP_TEXT);
                    break;
                case "/all":
                    getAllBook(chatId);
                    break;

                case "/find":
                    getById(chatId,num[1]);
                    break;
                    default: break;
            }
        }
    }
// /search 2

    private void getAllBook(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        ResponseEntity<BookListResponse> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:200/api/v1/book/all", BookListResponse.class);
        System.out.println(responseEntity.getBody().getData());
        message.setText(responseEntity.getBody().getData().toString());

        try {
            execute(message);
            log.info("Reply sent");
        }catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }
    private void getById(long chatId, String id){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        ResponseEntity<BookResponse> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:200/api/v1/book/"+id, BookResponse.class);
        System.out.println(responseEntity.getBody().getBook());
        message.setText(responseEntity.getBody().getBook().toString());

        try {
            execute(message);
            log.info("Reply sent");
        }catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }



   /* private void botAnswerUtils(String receivedMessage, long chatId, String userName){
        switch (receivedMessage){
            case"/start":
                startBot(chatId,userName);
                break;
            case"/help":
                sendHelpText(chatId,HELP_TEXT);
                break;
            default:break;
        }
    }*/
    private void  startBot(long chatId, String userName){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Приветик, " + userName + " ! Я - Телеграм бот :)");
        message.setReplyMarkup(Buttons.inlineMarkup());

        try {
            execute(message);
            log.info("Reply sent");
        }catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }

    private void sendHelpText(long chatId, String textToSend){
        SendMessage message=new SendMessage();
        message.setChatId(chatId);
        message.setText(textToSend);

        try {
            execute(message);
            log.info("Reply sent");
        }catch (TelegramApiException e){
            log.error(e.getMessage());
        }
    }
}
