package demo;

import demo.controller.ChatController;
import demo.controller.FeedController;
import demo.controller.UserController;
import demo.model.Chat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args){ SpringApplication.run(Main.class, args); }

    @Bean
    public CommandLineRunner addTemp(FeedController fc, UserController uc, ChatController cc){
        return (args) -> {
            fc.feed.AddItem("testBlock1", "this is first testblock", "lorem ipsum");
            fc.feed.AddItem("testBlock2", "this is second testblock", "lorem ipsum lorem ipsum");
            fc.feed.AddItem("testBlock3", "this is third testblock", "lorem ipsum lorem ipsum lorem ipsum");
            fc.feed.AddItem("testBlock4", "this is fourth testblock", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");

            uc.users.AddUser("testUser@users.be", "private");
            uc.users.AddUser("testUser02@users.be", "private");
            uc.users.AddUser("testUser03@users.be", "business");
            uc.users.AddUser("testUser04@users.be", "private");

            Chat c1 = new Chat(uc.getUsers().get(0), uc.getUsers().get(1));
            c1.sendMessage("testUser@users.be", "hello, i am testing");
            cc.sessions.addChatSession(c1);

        };
    }
}
