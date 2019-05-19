package com.ciaoshen.sia4.ch04.aop_around_43.concert;

// java util
import java.util.List;

public interface Performance {
    public void perform(int id);
    public String whatsOnStage();
    public int size();
    public List<String> getPerformanceList();
}
