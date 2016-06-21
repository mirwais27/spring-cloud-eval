package com.mirwais.eval.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fancyserver")
public interface BookmarkService {

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/bookmarks")
    List<Bookmark> getBookmarks(@PathVariable("userId") String userId);

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/bookmarks")
    Bookmark createBookmark(@PathVariable("userId") String userId, @RequestBody Bookmark bookmark);
}
