package org.example.design_pattern_23.observer;

import java.util.Observable;

/**
 * @author lifei
 */
public class BlogUser extends Observable {
    public void publishBlog(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        System.out.println("博主：发表新文章，文章标题：" + title + "，文章内容：" + content);
        this.setChanged();
        this.notifyObservers(article);
    }
}
