package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.CategoryAdd;
import com.bwf.shop.admin.bean.bo.CategorySearch;
import com.bwf.shop.admin.bean.bo.CategoryUpdate;
import com.bwf.shop.admin.bean.po.BrandCategories;
import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryMapper {

    /**
     * 根据父id查询所有的分类
     * @return 分类列表
     */
    List<Category> getAllCategoryListByParentId(@Param( "parent_id" ) Integer parent_id);

    /**
     * 查询所有的分类
     * @return 分类列表
     */
    List<Category> getAllCategoryList( @Param("bo") CategorySearch bo);


    /**
     * 查询分类总记录数
     * @return
     */
    int getCategoryCount( @Param("bo") CategorySearch bo );


    /**
     * 删除指定id的分类
     * @param id
     * @return受影响行数
     */

    int delCategoryById( @Param("id") Integer id);

    /**
     * 删除指定多个的分类
     * @param checked
     * @return 受影响行数
     */

    int delCategoryMtu( @Param("checked") Integer[] checked );

    /**
    * @MethodName: delBrandCategoryById
    * @Description: 根据category_id 删除 brand_categories 数据
    * @Param: [id]
    * @return: int 受影响行数
    * @Author: 李强
    * @Date 9:22 2020/9/23
    */
    int delBrandCategoryById( @Param("id") Integer id );

    /**
    * @MethodName: delBrandCategoryMTU
    * @Description: 根据选中的category_id数组 删除brand_categories 数据
    * @Param: [checked]
    * @return: int 受影响行数
    * @Author: 李强
    * @Date 9:23 2020/9/23
    */
    int delBrandCategoryMTU( @Param("checked") Integer[] checked );

    /**
    * @MethodName: delSpuAttrKeyCategoryById
    * @Description: 根据 category_id删除spu_attr_key_categories 中的数据
    * @Param: [id]
    * @return: int 受影响行数
    * @Author: 李强
    * @Date 9:24 2020/9/23
    */
    int delSpuAttrKeyCategoryById( @Param("id") Integer id );

    /**
    * @MethodName: delSpuAttrKeyCategories
    * @Description: 根据 category_id数组删除spu_attr_key_categories 中的数据
    * @Param: [checked]
    * @return: int
    * @Author: 李强 受影响行数
    * @Date 9:25 2020/9/23
    */
    int delSpuAttrKeyCategories( @Param("checked") Integer[] checked );


    /**
     * 添加分类
     * @param bo
     * @return 受影响行数
     */
    int addCategory(@Param("bo") CategoryAdd bo );

    /**
     * 添加品牌分类的品牌id
     * @param bo
     * @return 受影响行数
     */

    int addBrandCategory( @Param("bo") CategoryAdd bo ,@Param("brand_id") Integer[] brand_id);


    /**
     * 根据ID修改分类
     * @param id
     * @return 受影响行数
     */
    int updateCateGoryById(@Param("id") Integer id ,@Param("bo") CategoryUpdate bo);


    int updateCategoryAndBrand( @Param("brand_id") Integer brand_id ,@Param("category_id") Integer category_id);


    /**
     * 根据category的ID查询
     * @param id
     * @return
     */
    List<BrandCategories> getCategoryAndBrandByCategoryId( @Param("id") Integer id );


    int delCategoryAndBrandById(@Param("id") Integer id );



    /**
     * 根据名字查询是否存在
     * @param cate_name
     * @return 受影响行数
     */

    Integer getCategoryByName( @Param("cate_name") String cate_name );

}
