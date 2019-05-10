package com.ciaoshen.sia4.ch03.qualifier_33;

// my package
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Cold;
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Fruity;

@Cold
@Fruity
public class Popsicle implements Dessert {

    @Override
    public String toString() {
        return "Hello, I am Popsicle!";
    }

}
