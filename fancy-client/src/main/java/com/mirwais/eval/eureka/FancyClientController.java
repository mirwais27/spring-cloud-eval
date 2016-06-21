package com.mirwais.eval.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@EnableFeignClients
@RestController
public class FancyClientController {

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping(path = "/{userId}/show_bookmarks_feign", method = RequestMethod.GET)
    public String showBookmarksFeign(@PathVariable String userId) {
        List<Bookmark> bookmarks = bookmarkService.getBookmarks(userId);

        StringBuffer returnValue = new StringBuffer();
        for (int i = 0; i < bookmarks.size(); i++) {
            returnValue.append(bookmarks.get(i).toString() + "<br>");
        }
        return "Got bookmark (via feign) for user '" + userId + "': <br>" + returnValue.toString();
    }

}
