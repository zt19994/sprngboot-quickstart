package demo.springboot.dao.cluster;

import demo.springboot.entity.City;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 dao 接口类
 *
 * @author zt1994 2020/9/19 20:09
 */
public interface CityMapper {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
