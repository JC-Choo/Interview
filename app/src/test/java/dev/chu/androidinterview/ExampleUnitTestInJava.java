package dev.chu.androidinterview;

import org.junit.Test;

import dev.chu.androidinterview.access_modifier.AccessModifier;
import dev.chu.androidinterview.access_modifier.CallAccessModifier;

public class ExampleUnitTestInJava {
    @Test
    public void test() {
        AccessModifier am = new AccessModifier();
        am.test02 = 55;
        am.print02();
        am.toString();

        CallAccessModifier cam = new CallAccessModifier();
        cam.main();
        cam.tac2.toString();
    }
}
