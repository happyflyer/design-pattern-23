package org.example.design_pattern_23.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lifei
 */
public class MyObserver2 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Article article = (Article) arg;
        System.out.println("博主发布可新文章，快去看看吧");
        System.out.println("博客标题为：" + article.getTitle());
        System.out.println("博客内容为：" + article.getContent());
    }
}
