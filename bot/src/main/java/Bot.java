import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public String output = null;
    public boolean got;
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        Message inMessage = update.getMessage();
        got = false;
        GetInfo getInfo = new GetInfo(inMessage.getText(), this);
        Waiter waiter = new Waiter(inMessage.getChatId(), this);
        getInfo.start();
        waiter.start();
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(Long chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);

        try {
            execute(sendMessage);

        } catch (TelegramApiException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */

    @Override
    public String getBotUsername() {
        return "LabaWeaterBot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "1287888756:AAFRnryAbCrhGtp_yKZSp_lmW_j_40zEsa4";
    }
}


class Waiter extends Thread{
    long chatid;
    Bot bot;

    public Waiter(long chatid, Bot bot) {
        this.chatid = chatid;
        this.bot = bot;
    }

    @Override
    public void run() {
        aRun();
    }
    public synchronized void aRun(){
        System.out.println("i wait");
        bot.sendMsg(chatid, "please, wait");
        while (bot.got == false) {
            System.out.println("waiting: " + bot.got);
        }
        System.out.println("notified");
        bot.got = false;
        if (bot.output != "null") {
            bot.sendMsg(chatid, bot.output);
        }
        else {
            bot.sendMsg(chatid, "Sorry, no such city");
        }
    }
}