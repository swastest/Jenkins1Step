package simpleTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FailedTests {
    int a = 12;
    int b = 1;
    int c = 8;


    @Test
    void test00 (){
        Assertions.assertFalse( a ==12);

    }
    @Test
    void test01 (){
        Assertions.assertFalse( b ==1);
    }
    @Test
    void test02 (){
        Assertions.assertFalse( c ==8);
    }

    @Test
    void test03 (){
        Assertions.assertFalse( a > c);
    }

    @Test
    void test04 (){
        Assertions.assertFalse( c > b);
    }

}

//gradle clean test