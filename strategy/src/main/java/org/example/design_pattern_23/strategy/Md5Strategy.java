package org.example.design_pattern_23.strategy;

/**
 * @author lifei
 */
public class Md5Strategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("实现MD5加密");
    }
}
