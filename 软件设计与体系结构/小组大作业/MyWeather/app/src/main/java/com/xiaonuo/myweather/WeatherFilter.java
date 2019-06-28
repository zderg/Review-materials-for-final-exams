package com.xiaonuo.myweather;

public class WeatherFilter implements WeatherFilterInterface {
    @Override
    public String[] getDataFromWeatherJson(String json) {
        String[] strArray = new String[4];
        //获取温度
        int x = json.indexOf("tmp");
        int y = json.indexOf(":", x);
        int j = json.indexOf(",", x);
        final String temp1 = json.subSequence(y + 2, j - 1).toString();
        strArray[0] = temp1;

        //天气描述+体感温度
        x = json.indexOf("cond_txt");
        y = json.indexOf(":", x);
        j = json.indexOf(",", x);
        String temp = json.subSequence(y + 2, j - 1).toString();
        strArray[1] = temp;
        x = json.indexOf("fl");
        y = json.indexOf(":", x);
        j = json.indexOf(",", x);
        strArray[2] = json.subSequence(y + 2, j - 1).toString();

        //获取刷新时间
        x = json.indexOf("loc\"");
        y = json.indexOf(":", x);
        j = json.indexOf(",", x);
        temp = json.subSequence(y + 2, j - 1).toString();
        final String temp3 = temp.split(" ")[1];
        strArray[3] = temp3;

        return strArray;
    }


}
