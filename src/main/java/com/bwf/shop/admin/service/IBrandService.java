package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.BrandAdd;
import com.bwf.shop.admin.bean.bo.BrandSearch;
import com.bwf.shop.admin.bean.bo.BrandUpdate;
import com.bwf.shop.admin.bean.po.Brand;
import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 品牌模块的 业务逻辑层接口
 */
public interface IBrandService {

    List<Brand> getAllBrandList(BrandSearch bo);

    /**
     * 根据ID获取一个品牌列表
     * @return
     */
    Brand getOneBrandById( @Param("id") Integer id );

    /**
     * 根据编号删除一个品牌
     * @param id 要删除的品牌编号
     * @return 删除是否成功
     */
    boolean deleteOne( Integer id);

    /**
     * 根据编号删除一个品牌
     * @param checked 要删除的品牌编号
     * @return 删除是否成功
     */
    boolean deleteMtu(Integer[] checked);

    int allTotal();


    /**
     * 添加一行数据
     * @param bo 要增加的bo对象
     * @return 是否添加成功
     */
    boolean addBrand(BrandAdd bo);

    /**
     * 根据ID修改分类
     * @param id
     * @return 受影响行数
     */
    boolean updateBrandById( Integer id , BrandUpdate bo );


    /**
     * 根据名字查询是否存在
     * @param
     * @return 是否存在
     */
    List<Brand> getBrandByName(  );

}
