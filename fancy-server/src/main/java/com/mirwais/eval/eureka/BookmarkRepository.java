package com.mirwais.eval.eureka;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class BookmarkRepository {

    private static HashMap<String, List<Bookmark>> booksmarks = new HashMap<String, List<Bookmark>>();

    private Logger logger = Logger.getLogger(BookmarkRepository.class);

    public BookmarkRepository() {
        booksmarks.put("mirwais", Arrays.asList(
                new Bookmark("mirwais", "www.heise.de", "IT news", "IT"),
                new Bookmark("mirwais", "www.golem.de", "IT news", "IT"),
                new Bookmark("mirwais", "www.spiegel.de", "Common news", "News")));
        booksmarks.put("zallah", Arrays.asList(
                new Bookmark("zallah", "www.gala.de", "VIP news", "VIP"),
                new Bookmark("zallah", "www.cosmopoltian.de", "VIP news", "VIP"),
                new Bookmark("zallah", "www.sz.de", "Common news", "News")));
    }

    public void deleteBokkmarks(String userId) {
        booksmarks.remove(userId);
    }

    public List<Bookmark> findByUserId(String userId) {
        List<Bookmark> bookmarks = booksmarks.get(userId);
        logger.info("Found booksmarks for uer '" + userId + "': " + bookmarks.size());
        return bookmarks;
    }

    public Bookmark save(Bookmark bookmarkInstance) {
        String userId = bookmarkInstance.getUserId();
        List<Bookmark> bookmarks = booksmarks.get(userId);
        bookmarks.add(bookmarkInstance);
        this.booksmarks.put(userId, bookmarks);

        logger.info("Saved bookmark for user '" + bookmarkInstance.getUserId() + "': " + bookmarkInstance);
        return bookmarkInstance;
    }
}
