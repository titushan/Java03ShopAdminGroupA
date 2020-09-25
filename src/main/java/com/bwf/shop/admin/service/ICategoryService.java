package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.BrandCategories;
import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface ICategoryService {

    /**
     * 根据父id查询所有的分类
     * @return 分类列表
     */

    List<Category> getAllCategoryListByParentId( Integer parent_id);

    /**
     * 查询所有的分类
     * @return 分类列表
     */
    List<Category> getAllCategoryList(CategorySearch bo);


    /**
     * 查询分类总记录数
     * @return
     */
    int getCategoryCount( CategorySearch bo);


    /**
     * 删除指定id的分类
     * @param id
     * @return是否成功
     */

    boolean delCategoryById( Integer id);

    /**
     * 删除指定多个的分类
     * @param checked
     * @return 是否成功
     */

    boolean delCategoryMtu(  Integer[] checked);

    /**
     * 添加分类
     * @param bo
     * @return 是否添加成功
     */
    boolean addCategory(CategoryAdd bo );


    /**
     * 添加品牌分类的品牌id
     * @param bo
     * @return 是否成功
     */
    boolean addBrandCategory( CategoryAdd bo ,Integer[] brand_id);


    /**
     * 根据ID修改分类
     * @param id
     * @return 是否修改成功
     */
    boolean updateCateGoryById(Integer id , CategoryUpdate bo);


    /**
     * 根据category的ID查询
     * @param id
     * @return 返回符合条件的数据
     */
    List<BrandCategories> getCategoryAndBrandByCategoryId(Integer id );

    boolean updateCategoryAndBrand(Integer brand_id , Integer category_id);


    boolean delCategoryAndBrandById( Integer id);


    /**
     * 根据名字查询是否存在
     * @param cate_name
     * @return 是否成功
     */

    boolean getCategoryByName( String cate_name );



    /**
     * @MethodName: delBrandCategoryById
     * @Description: 根据category_id 删除 brand_categories 数据
     * @Param: [id]
     * @return: int 受影响行数
     * @Author: 李强
     * @Date 9:22 2020/9/23
     */
    boolean delBrandCategoryById( Integer id );

    /**
     * @MethodName: delBrandCategoryMTU
     * @Description: 根据选中的category_id数组 删除brand_categories 数据
     * @Param: [checked]
     * @return: int 受影响行数
     * @Author: 李强
     * @Date 9:23 2020/9/23
     */
    boolean delBrandCategoryMTU( Integer[] checked );

    /**
     * @MethodName: delSpuAttrKeyCategoryById
     * @Description: 根据 category_id删除spu_attr_key_categories 中的数据
     * @Param: [id]
     * @return: int 受影响行数
     * @Author: 李强
     * @Date 9:24 2020/9/23
     */
    boolean delSpuAttrKeyCategoryById( Integer id );

    /**
     * @MethodName: delSpuAttrKeyCategories
     * @Description: 根据 category_id数组删除spu_attr_key_categories 中的数据
     * @Param: [checked]
     * @return: int
     * @Author: 李强 受影响行数
     * @Date 9:25 2020/9/23
     */
    boolean delSpuAttrKeyCategories( Integer[] checked );


}
