package com.ciaoshen.sia4.ch04.aop_around_43.concert;

// java util
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuoDeGangZhuanChang implements Performance {

    private String stage;

    private String[] performances = new String[]{
        "《你要唱歌》", "《你要高雅》", "《你得娶我》", "《你这半辈子》", "《你要做善人》",
        "《你好新北京》", "《你是我的玫瑰》", "《你要折腾》", "《你要吐槽》", "《你压力大吗》"};

    public void perform(int id) {
        if (id < 0 || id >= performances.length) {
            System.out.println("No such option, please check you order.");
            return;
        }
        stage = performances[id];
    }

    public String whatsOnStage() {
        if (stage == null) {
            return "目前没有表演";
        }
        return stage;
    }

    public int size() {
        return performances.length;
    }

    public List<String> getPerformanceList() {
        return new ArrayList<String>(Arrays.asList(performances));
    }
}
