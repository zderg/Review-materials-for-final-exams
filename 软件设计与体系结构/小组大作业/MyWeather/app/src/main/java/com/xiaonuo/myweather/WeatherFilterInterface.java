package com.xiaonuo.myweather;

/**
 * 天气数据过滤器接口
 */
public interface WeatherFilterInterface {

    /**
     * 从Json中过滤出tmp（温度），cond_txt（天气描述），fl（体感温度），loc（刷新时间）。
     * 按上述顺序存入String数组
     *
     * @param json 天气Json数据
     *             例：
     *             [{
     *             "now": {
     *             "cloud": "8",
     *             "cond_code": "100",
     *             "cond_txt": "晴",
     *             "fl": "33",
     *             "hum": "26",
     *             "pcpn": "0.0",
     *             "pres": "997",
     *             "tmp": "33",
     *             "vis": "22",
     *             "wind_deg": "191",
     *             "wind_dir": "西南风",
     *             "wind_sc": "2",
     *             "wind_spd": "6"
     *             },
     *             "basic": {
     *             "admin_area": "北京",
     *             "cid": "CN101010300",
     *             "cnty": "中国",
     *             "lat": "39.92148972",
     *             "location": "朝阳",
     *             "lon": "116.48641205",
     *             "parent_city": "北京",
     *             "tz": "+8.00"
     *             },
     *             "status": "ok",
     *             "update": {
     *             "loc": "2019-05-23 19:30",
     *             "utc": "2019-05-23 11:30"
     *             }
     *             }]
     * @return String数组（tmp，cond_txt，fl，loc）
     */
    public String[] getDataFromWeatherJson(String json);

}
