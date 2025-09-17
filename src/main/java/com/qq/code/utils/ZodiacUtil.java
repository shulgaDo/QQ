package com.qq.code.utils;

public class ZodiacUtil {

    public static String getZodiac(int month, int day){
        switch (month) {
            case 1: return (day <= 19) ? "摩羯座" : "水瓶座";
            case 2: return (day <= 18) ? "水瓶座" : "双鱼座";
            case 3: return (day <= 20) ? "双鱼座" : "白羊座";
            case 4: return (day <= 19) ? "白羊座" : "金牛座";
            case 5: return (day <= 20) ? "金牛座" : "双子座";
            case 6: return (day <= 21) ? "双子座" : "巨蟹座";
            case 7: return (day <= 22) ? "巨蟹座" : "狮子座";
            case 8: return (day <= 22) ? "狮子座" : "处女座";
            case 9: return (day <= 22) ? "处女座" : "天秤座";
            case 10: return (day <= 23) ? "天秤座" : "天蝎座";
            case 11: return (day <= 22) ? "天蝎座" : "射手座";
            case 12: return (day <= 21) ? "射手座" : "摩羯座";
            default: return ""; // 理论上不会到这里
        }
    }
}
