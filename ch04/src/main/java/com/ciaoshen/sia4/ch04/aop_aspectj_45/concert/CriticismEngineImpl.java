package com.ciaoshen.sia4.ch04.aop_aspectj_45.concert;

// java util
import java.util.Random;

public class CriticismEngineImpl implements CriticismEngine {

    private static final String[] CRIT = new String[]{
        "滚下去~滚下去~滚下去~", "吁吁吁吁吁吁~~~", "再来一个！", "我爱你！", "啪啪啪啪啪~~~"
    };
    private static final Random R = new Random();

    public String getCriticism() {
        return CRIT[R.nextInt(CRIT.length)];
    }

}
