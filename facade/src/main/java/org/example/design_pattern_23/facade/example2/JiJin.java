package org.example.design_pattern_23.facade.example2;

/**
 * @author lifei
 */
public class JiJin {
    private final GuPiao guPiao;
    private final QiHuo qiHuo;
    private final GuoZhai guoZhai;

    public JiJin() {
        this.guPiao = new GuPiao();
        this.qiHuo = new QiHuo();
        this.guoZhai = new GuoZhai();
    }

    public void maiJiJinA() {
        this.guoZhai.mai();
        this.qiHuo.mai();
    }

    public void maiJiJinB() {
        this.guPiao.chao();
        this.qiHuo.mai();
        this.guoZhai.mai();
    }
}
