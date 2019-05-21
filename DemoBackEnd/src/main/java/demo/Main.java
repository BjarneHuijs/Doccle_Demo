package demo;

import demo.controller.FeedController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args){ SpringApplication.run(Main.class, args); }

    @Bean
    public CommandLineRunner addTemp(FeedController fc){
        return (args) -> {
            fc.feed.AddItem("testblock1", "this is first testblock", "lorem ipsum");
            fc.feed.AddItem("testblock2", "this is second testblock", "lorem ipsum lorem ipsum");
            fc.feed.AddItem("testblock3", "this is third testblock", "lorem ipsum lorem ipsum lorem ipsum");
            fc.feed.AddItem("testblock4", "this is fourth testblock", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum");
        };
    }
}
