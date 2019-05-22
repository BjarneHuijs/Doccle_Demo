package demo.model;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List<FeedItem> items;

    public Feed(){
        items = new ArrayList<>();
    }

    public Feed(List<FeedItem> content){
        items = new ArrayList<>();
        setItems(content);
    }

    public void AddItem(String title, String shortText, String content){
        items.add(new FeedItem(items.size(), title, shortText, content));
    }

    public List<FeedItem> getFeed() {
        return items;
    }

    private void setItems(List<FeedItem> items) {
        this.items = items;
    }

    public FeedItem getItem(int id){
        return items.get(id);
    }
}
