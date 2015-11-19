package com.mirwais.eval.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class BookmarkRestController implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Override
    public List<Bookmark> getBookmarks(@PathVariable String userId) {
        System.out.println("Get bookmarks for user '" + userId + "' was called!");
        return this.bookmarkRepository.findByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/bookmarks")
    Bookmark createBookmark(@PathVariable String userId, @RequestBody Bookmark bookmark) {
        Bookmark bookmarkInstance = new Bookmark(
                userId,
                bookmark.getHref(),
                bookmark.getDescription(),
                bookmark.getLabel());
        return this.bookmarkRepository.save(bookmarkInstance);
    }

}
