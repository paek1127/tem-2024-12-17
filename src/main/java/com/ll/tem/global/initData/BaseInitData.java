package com.ll.tem.global.initData;

import com.ll.tem.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;

    @Autowired
    @Lazy
    private BaseInitData self;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
          self.work1();
        };
    }

    @Transactional
    public void work1() {
        if (postService.count() > 0) return;

        postService.write("title1", "content1");
        postService.write("title2", "content2");
        postService.write("title3", "content3");
    }
}
