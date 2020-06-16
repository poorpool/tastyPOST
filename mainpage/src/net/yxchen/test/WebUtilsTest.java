package net.yxchen.test;

import net.yxchen.utils.WebUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebUtilsTest {

    @Test
    public void parseStringToIntList() {
        System.out.println(WebUtils.parseStringToIntListByComma("2,3, 9"));
    }
}