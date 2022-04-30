package tests.simpleTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SkippedTests {
    int a = 12;
    int b = 1;
    int c = 8;


    @Disabled ("Так надо 0")
    @Test
    void test00() {
        Assertions.assertFalse(a == 12);

    }

    @Disabled ("Так надо 1")
    @Test
    void test01() {
        Assertions.assertFalse(b == 1);
    }

    @Disabled ("Так надо 2")
    @Test
    void test02() {
        Assertions.assertFalse(c == 8);
    }

    @Disabled ("Так надо 3")
    @Test
    void test03() {
        Assertions.assertFalse(a > c);
    }


}
