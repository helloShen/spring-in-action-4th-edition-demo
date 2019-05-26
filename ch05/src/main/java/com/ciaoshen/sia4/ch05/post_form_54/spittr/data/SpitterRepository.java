package com.ciaoshen.sia4.ch05.post_form_54.spittr.data;

// my project package
import com.ciaoshen.sia4.ch05.post_form_54.spittr.Spitter;

public interface SpitterRepository {

    public Spitter save(Spitter spitter);

    public Spitter findByUsername(String username);

}
