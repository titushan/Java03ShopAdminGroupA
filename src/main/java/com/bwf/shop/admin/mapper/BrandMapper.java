package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.BrandAdd;
import com.bwf.shop.admin.bean.bo.BrandSearch;
import com.bwf.shop.admin.bean.bo.BrandUpdate;
import com.bwf.shop.admin.bean.po.Brand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 品牌的数据访问层 接口
 */
@Repository
public interface BrandMapper {

    /**
     * 获取所有的品牌列表
     * @return
     */
     List<Brand> getAllBrandList( @Param("bo") BrandSearch bo );


    /**
     * 根据ID获取一个品牌列表
     * @return
     */
    Brand getOneBrandById( @Param("id") Integer id );


    /**
     * 根据编号删除一个品牌
     * @param id 要删除的品牌编号
     * @return 受影响行数
     */
     int deleteOne( @Param("id") Integer id);

    /**
     * 根据编号删除多个品牌
     * @param checked 要删除的编号数组
     * @return 受影响行数
     */
     int deleteMtu( @Param("checked") Integer[] checked );


     int allTotal();

    /**
     * 添加一行数据
     * @param bo 要增加的bo对象
     * @return 返回受影响的行数
     */
     int addBrand(@Param("bo") BrandAdd bo);


    /**
     * 根据id更新品牌
     * @param id
     * @param bo
     * @return 受影响行数
     */
     int updateBrandById(@Param("id") Integer id ,@Param("bo") BrandUpdate bo);

    /**
     * 根据名字查询是否存在
     * @param
     * @return 行数
     */
    List<Brand> getBrandByName(  );

}
