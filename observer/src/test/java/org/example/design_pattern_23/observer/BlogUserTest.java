package org.example.design_pattern_23.observer;

import org.junit.Test;

public class BlogUserTest {
    @Test
    public void test() {
        BlogUser blogUser = new BlogUser();
        blogUser.addObserver(new MyObserver2());
        blogUser.publishBlog("哈哈，博主上线了", "大家多来访问");
    }
}
