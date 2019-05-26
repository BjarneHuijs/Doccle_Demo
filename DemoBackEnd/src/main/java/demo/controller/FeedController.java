package demo.controller;

import demo.model.Feed;
import demo.model.FeedItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class FeedController {

    public Feed feed;
    public List<FeedItem> articles;
    private int i = 0;

    public FeedController() {
        feed = new Feed();
        articles = new ArrayList<>();
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public List<FeedItem> GetFeed() {
        List<FeedItem> revFeed = new ArrayList<>();
        for (int i = feed.getFeed().size() - 1; i >= 0; i--) {
            revFeed.add(feed.getFeed().get(i));
        }
        return revFeed;
    }

    @RequestMapping(value = "/feed/{title}", method = RequestMethod.GET)
    public FeedItem getItem(@PathVariable String title) {
        int id = Integer.MIN_VALUE;
        for(int i = 0; i < feed.getFeed().size(); i++) {
            if(feed.getItem(i).getTitle().equals(title)){id = i;}
        }
        if(title != null && id >= 0){ return feed.getItem(id); }
        else throw new IllegalArgumentException("this item does not exist, please refresh your feed");
    }

    @RequestMapping(value = "/refreshFeed", method = RequestMethod.GET)
    public List<FeedItem> updateFeed() {
        if(i < articles.size()){
            feed.AddItem(articles.get(i));
            i++;
        }
        //feed.AddItem("testBlock" + (feed.getFeed().size() + 1), "This is the " + (feed.getFeed().size() + 1) + "th test text", "lorem ipsum lorem ipsum lorem ipsum lorem ipsum\n lorem ipsum lorem ipsum lorem ipsum lorem ipsum");
        return this.GetFeed();
    }
}
