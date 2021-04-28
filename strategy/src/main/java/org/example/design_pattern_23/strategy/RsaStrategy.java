package org.example.design_pattern_23.strategy;

/**
 * @author lifei
 */
public class RsaStrategy implements Strategy {
    @Override
    public void encrypt() {
        System.out.println("实现RSA加密");
    }
}
