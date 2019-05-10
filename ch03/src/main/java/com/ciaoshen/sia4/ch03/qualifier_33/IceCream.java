package com.ciaoshen.sia4.ch03.qualifier_33;

import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Cold;
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Creamy;

@Cold
@Creamy
public class IceCream implements Dessert {

    @Override
    public String toString() {
        return "Hello, I am IceCream!";
    }

}
