package cn.com.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.Base64Utils;

/**
 * Description:
 * User: wangpl
 * Date: 2019-10-30
 * Time: 11:19
 */

public class Base64Test {

    @Test
    public void testBase64() {

        String str = "MwADM1ATMwETNxIiOi0GRqd3cnpnIsIytPWuMXGK6X2Y5PCb5qiq56yY5K675S2Z6Cib59OY6Qio5iojI6R2Y6JCL9JSM0ADMxYjI6ISbipXekNmeiwiI4QTN1oiKqoSNzEjI6ICakhHbkNmeiwiICC44pgqilvLtmXKko/4unXZslDIvl/6jlnrlm7Iklb4hlnbimj6lpj6gpPbhlj7mn/4unzIvv76mnnbopTomnb4hlnbim/4unvbopX5sm3pvkjigAOei8+epQi+j7eOheauuca+rUauhIWOkZmOi8+ejkaejneOqca+lLiegAOOkda+rNier4S+m8+eoKWejcaehjiehMW+m8+uiRW+v5W+uxeOhQWehGWevbW+g4WekPWegAOuhQe+o7SegAOOn9SutIWegAOeouiuvui+m8+eoKWejcaOinielxWuiPWuruium8S+m8+OqKW+u0aeg1aOp6SulMW+hWa+h7eOh7e+m8+epfa+gwiuucWug4W+m8+ei8+eruieufWevDiOgKaum4SOjBiOjSWusCiemVauhOWuptW+qQWej4SOi8+eruieufWevDiOgKa+m8+eKoqY57Sr5N6J6ReY6J265ReY6EWL6XyL5sWY52Sp54CZ5BC44EWL6GuZ6VOr5e2Z6LqL5OuL5X6b5NiL5oYIknHqrnfqukTYto7IukTYtoXpimvJvvL6rojqkl7Ytm/4unrJvk7LpnLiOicnZ5pmI7pjIPZleLhHeyNnbiwiI4+Y5sWY5QmZ6Jyp5hqY5Nyp5hqY5GWZ5ACo5Mib5Cib59OY6Qio5iojIj1mcz5mIsIiKPKZ5L6a5iojIthnciRGZmJyeCJ9";
        String encoded = StringUtils.reverse(org.apache.commons.lang3.StringUtils.substring(str, 0, -3)) + org.apache.commons.lang3.StringUtils.substring(str, -3);

        System.out.println(new String(Base64.decodeBase64(encoded)));
        System.out.println(JSONObject.toJSONString(Base64.decodeBase64(encoded)));
    }

    @Test
    public void testBoole() {
        System.out.println(!"07".equals("07") && !(true && false));
    }

    @Test
    public void printStr() {
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAN6irXTd8sepps/RGtlnP1uWUNdWJSqq8lMxjB/9Rrm9dil6FcQLWhpFgO76hZTljA5cQA7iqjrvRZEv"
                + "ZzKZNvoRzcdGODgzZXs3y6L8bzNxPWw3rBGUZ0hxrxVoeI9YBPVibhdWn7SQE6rZ"
                + "aJ8smN44vFkHcTKraYLMrKyzpolfAgMBAAECgYAtRel9/XBUV9R7KCuMkClbJ4sS"
                + "7wqpzY9viYDUNH4AYV24+4GXlzNgakfY0Qr/B1rexLWmEUPKrkN4TapvqKZ7/Kwc"
                + "+0NF2pwjOUSm4ikznqht2VT3Agmwpc6qN+s1o5PRUm8KBI9gMbMe15WpzMqj0XJ2"
                + "XaSY4/BVt2YPc/zKgQJBAPMy8f5gDh6FtGH7tXzH/d4oFehO10LikGldLBLeFiKn"
                + "sHtzvufKXrfPyfUZfEMrp/wqEYnzKZLqpN44FYSbXUECQQDqWqSUCsc25MY2dKmK"
                + "VPDY1KtkTkHjA57SEUDIRg7QLlzGPRamPn2lB0Nm4g9AjP3ClowaaZFMGy2dtF4h"
                + "uh6fAkBmxrDd/1n4LCj+/5DDGwF+URJxCmCOM5Ez9dwaXSCdpKBAi7mx2yQMKhP/"
                + "MLYC7QAg4OZolgqLu/3Qq4Lsd3wBAkEA5KhcPDXn+h9tZmSdp2MJPAcE03Gnx6AY"
                + "rk43LzFr8qPJ0YJ5PutqHELh+NhImWr3jYzmVj76jY9XCrCZx76ZcQJBAJnaYsi/"
                + "AB14tozmOFiePtNxFSr9z5kE+V91ljtAX8sgA8yO47aAZmVJnM+pw2IVowwZW4dV"
                + "ZlkgLhSYyetmD6g=";
        System.out.println(privateKey);
    }

}
