package simpleTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassedTests {

    int a = 12;
    int b = 1;
    int c = 8;

    @Test
    void test00 (){
        Assertions.assertTrue( a ==12);

    }
  @Test
    void test01 (){
        Assertions.assertTrue( b ==1);
    }
    @Test
    void test02 (){
        Assertions.assertTrue( c ==8);
    }

    @Test
    void test03 (){
        Assertions.assertTrue( a > c);
    }

    @Test
    void test04 (){
        Assertions.assertTrue( c > b);
    }

 @Test
    void test05 (){
        Assertions.assertTrue( b < c);
    }

 @Test
    void test06 (){
        Assertions.assertTrue( c < a);
    }


}
