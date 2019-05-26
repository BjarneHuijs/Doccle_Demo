package demo;

import demo.controller.ChatController;
import demo.controller.FeedController;
import demo.controller.UserController;
import demo.model.Chat;
import demo.model.FeedItem;
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
            fc.feed.AddItem("KBC Autolease", "KBC biedt voordelen aan aan bedrijven die een nieuwe leasewagen nemen",
                    "Tussen 1 April en 30 Juni biedt KBC een voordelige autolease aan voor bedrijfswagens. Er is keuze tussen verschillende merken en modellen.");
            fc.feed.AddItem("VAB legt uit: Parkeermeter stuk?", "Je wilt braaf een ticketje nemen om te betalen voor je parkeerplaats, maar dan blijkt de parkeermeter stuk. Wat nu?",
                    "Parkeermeter stuk? Leg je parkeerschijf!\n" +
                            "\n" +
                            "Daar is de wegcode heel duidelijk in: is de parkeermeter stuk, dan moet je de parkeerschijf gebruiken. Dat betekent wel dat de parkeertijd beperkt is, want met een parkeerschijf mag je maximaal twee uur aaneensluitend parkeren. Maar wat als er vlakbij nog een andere parkeermeter staat? Daarin is de wegcode niet zo duidelijk. Als er binnen een redelijke afstand een andere meter staat, dan kan een rechter bij betwisting toch oordelen dat de bestuurder daar een ticketje had moeten nemen. Algemeen wordt echter aanvaard dat je niet eindeloos op zoek moet gaan naar een werkende automaat.");
            fc.feed.AddItem("Allianz, uitzichten en opportuniteiten", "Met de verandering in het verzekeringslandschap dankzij de digitalisatie wordt risicopreventie belangrijker dan risicomanagement. Allianz legt uit wat dit inhoudt...",
                    "Er zijn tectonische schiftingen onderweg in de verzekeringsindustrie en er zijn geen prijzen voor wie raadt wat de drijfveer is. Je raadt het allemaal, Technologie.\n" +
                     "Van 'wearables' tot artificiële intelligentie tot zelfsturende wagens en het 'Internet Of Things', digitalisatie is het verzekeringslandschap aan hoge snelheid aan het veranderen. Dit verplicht Allianz om te innoveren met hun aanbod.");
            fc.articles.add(new FeedItem(fc.feed.getFeed().size(),"Telenet voert werken uit", "Telenet voert werken uit om nieuwe netwerkkabels te plaatsen",
                    "Om de servicekwaliteit die Telenet aanbiedt te verbeteren zal in regio A tijdens de maand Juli een stratenblok opengebroken worden om nieuwe en snellere netwerkkabels te plaatsen"));

            uc.users.AddUser("bjarne@users.be", "private");
            uc.currentUser = uc.users.getUser("bjarne@users.be");
            uc.users.AddUser("Sarah@users.be", "private");
            uc.users.AddUser("Mauranne@users.be", "private");
            uc.users.AddUser("Quinten@users.be", "private");

            Chat c1 = new Chat(uc.getUser("Sarah@users.be"), uc.getUser("Sarah@users.be"));
            uc.getUser("bjarne@users.be").addConnection(uc.getUser("Sarah@users.be"));

            cc.sessions.addChatSession(c1);
            uc.setCC(cc);

        };
    }
}
