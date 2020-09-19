package demo.springboot.service.impl;

import demo.springboot.dao.CityMapper;
import demo.springboot.entity.City;
import demo.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zt1994 2020/9/19 20:08
 */
@Service
public class CityControllerImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    /**
     * 通过名称查找城市
     *
     * @param cityName
     * @return
     */
    @Override
    public City findCityByName(String cityName) {
        return cityMapper.findByName(cityName);
    }
}
