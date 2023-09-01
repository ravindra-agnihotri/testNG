package framework.core.testNGFunctns;

import org.testng.annotations.Test;

public class One {


    @Test(groups = "oneGroup")
    public void g(){
        System.out.println("3");
    }
    @Test(groups = "smoke")
    public void z(){
        System.out.println("1");
    }

    @Test
    public void c(){
        System.out.println("2");
    }
}
