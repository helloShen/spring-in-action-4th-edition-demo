package com.ciaoshen.sia4.ch06;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

    @NotNull
    @Size(min=2, max=30, message="{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=2, max=30, message="{lastName.size}")
    private String lastName;
    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;
    @NotNull
    @Size(min=5, max=25, message="{password.size}")
    private String password;

    // methods omitted
    // ... ...

}
