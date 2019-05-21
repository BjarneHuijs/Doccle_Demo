package demo.controller;

import demo.model.Feed;
import demo.model.FeedItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedController {

    public Feed feed;

    public FeedController() {
        feed = new Feed();
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public List<FeedItem> GetFeed() {
        System.out.println(feed.getFeed());
        return feed.getFeed();
    }

    @RequestMapping(value = "/feed/{title}", method = RequestMethod.GET)
    public FeedItem getItem(@PathVariable String title, @RequestBody int id) {
        if(title != null && id >= 0){ return feed.getItem(id); }
        else throw new IllegalArgumentException("this item does not exist, please refresh your feed");
    }

}
