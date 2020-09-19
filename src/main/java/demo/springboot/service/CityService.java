package demo.springboot.service;

import demo.springboot.entity.City;

/**
 * @author zt1994 2020/9/19 20:07
 */
public interface CityService {

    /**
     * 通过名称查找城市
     *
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
}
