package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ISpuAttrKeyService {




    /**
     * 查询所有的属性
     * @return 查询到的属性列表
     */
    List<SpuAttrKey> getAllSpuAttrKeyList( SpuAttrKeySearch bo);


    /**
     * 查询总记录数
     * @return 总记录数
     */
    int getSpuAttrKeyCount( SpuAttrKeySearch bo );


    /**
     * 删除单个数据
     * @param id
     * @return 是否成功
     */
    boolean delSpuAttrKeyOne( Integer id);

    /**
     * 批量删除
     * @param checked
     * @return 是否成功
     */
    boolean delSpuAttrKeyMtu( @Param("checked") Integer[] checked);



    /**
     * 添加属性
     * @param bo
     * @return 是否成功
     */

    boolean addSpuAttrKey( SpuAttrKeyAdd bo);


    /**
     * 添加属性值
     * @param vbo
     * @return 是否成功
     */
    boolean addSpuAttrValue(  SpuAttrValueAdd vbo , SpuAttrKeyAdd kbo );


    /**
     * 根据id查询属性已经存在的属性值
     * @param id
     * @return 已经存在的属性值
     */
    List<SpuAttrValue> getAllSpuAttrValueById( Integer id);


    /**
     * 修改属性
     * @param id bo
     * @return 是否成功
     */
    boolean updateSpuAttrKeyById(Integer id , SpuAttrKeyUpdate bo);

    /**
     * 删除选中的属性值
     * @param checked
     * @return 是否成功
     */
    boolean delSpuAttrValueById(@Param("checked") Integer[] checked);


    /**
     * 删除单个数据
     * @param id
     * @return 是否成功
     */
    boolean delSpuAttrValueOne( @Param("id") Integer id);


    /**
     * 批量删除
     * @param checked
     * @return 是否成功
     */
    boolean delSpuAttrValueMtu( @Param("checked") Integer[] checked);

    /**
     * 添加属性与分类的相关信息
     * @param cbo
     * @return  是否成功
     */
    boolean addSpuSttrKeyCategories(  SpuSttrKeyCategoriesAdd cbo);


    /**
     * 根据ID删除属性与分类的相关信息
     * @param id
     * @return 是否成功
     */
    boolean delSpuSttrKeyCategoriesById( Integer id);


    /**
     * 根据选择ID数组删除属性与分类的相关信息
     * @param checked
     * @return 是否成功
     */
    boolean delSpuSttrKeyCategoriesMtu( Integer[] checked);



    /**
     * 根据名字查询是否存在
     * @param key_name
     * @return 受影响行数
     */
    boolean getIsExistByKeyName( String key_name );



}
