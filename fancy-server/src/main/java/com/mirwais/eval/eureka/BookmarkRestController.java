package com.mirwais.eval.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan
class BookmarkRestController implements BookmarkService {

    // TODO Mirwais: This does not work with Brixton.M3 release but why?
    @Value("${database.url}")
    String dbURL = "EMPTY";

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Override
    public List<Bookmark> getBookmarks(@PathVariable String userId) {
        System.out.println("Get bookmarks for user '" + userId + "' was called! Database URL is " + this.dbURL);
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
