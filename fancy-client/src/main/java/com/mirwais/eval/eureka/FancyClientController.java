package com.mirwais.eval.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableFeignClients
@RestController
public class FancyClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping("/")
    public String home() {
        return restTemplate.getForObject("http://fancyserver", String.class).toString() ;
    }

    @RequestMapping(path = "/{userId}/show_bookmarks_rest", method = RequestMethod.GET)
    public String showBookmarksRest(@PathVariable String userId) {
        ResponseEntity<List<Bookmark>> exchange =
                this.restTemplate.exchange(
                        "http://fancyserver/{userId}/bookmarks",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Bookmark>>() {
                        },
                        userId);
        exchange.getBody().forEach(System.out::println);
        return "Got bookmarks (via rest) for user '" + userId + "'";
    }

    @RequestMapping(path = "/{userId}/show_bookmarks_feign", method = RequestMethod.GET)
    public String showBookmarksFeign(@PathVariable String userId) {
        List<Bookmark> bookmarks = bookmarkService.getBookmarks(userId);
        bookmarks.forEach(System.out::println);
        return "Got bookmarks (via feign) for user '" + userId + "'";
    }

}
