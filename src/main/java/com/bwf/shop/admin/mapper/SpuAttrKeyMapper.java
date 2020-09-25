package com.bwf.shop.admin.mapper;


import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpuAttrKeyMapper {


    /**
     * 查询所有的属性
     * @return 查询到的属性列表
     */
    List<SpuAttrKey> getAllSpuAttrKeyList(@Param("bo") SpuAttrKeySearch bo);

    /**
     * 查询总记录数
     * @return 总记录数
     */
    int getSpuAttrKeyCount(@Param("bo") SpuAttrKeySearch bo);


    /**
     * 删除单个数据
     * @param id
     * @return 返回受影响行数
     */
    int delSpuAttrKeyOne( @Param("id") Integer id);


    /**
     * 批量删除
     * @param checked
     * @return 返回受影响行数
     */
    int delSpuAttrKeyMtu( @Param("checked") Integer[] checked);

    /**
     * 添加属性
     * @param bo
     * @return 受影响行数
     */

    int addSpuAttrKey( @Param("bo") SpuAttrKeyAdd bo);


    /**
     * 添加属性值
     * @param vbo
     * @return 受影响行数
     */
    int addSpuAttrValue( @Param("vbo") SpuAttrValueAdd vbo , @Param("kbo") SpuAttrKeyAdd kbo);


    /**
     * 根据id查询属性已经存在的属性值
     * @param id
     * @return 已经存在的属性值
     */
    List<SpuAttrValue> getAllSpuAttrValueById(@Param("id") Integer id);


    /**
     * 修改属性
     * @param id bo
     * @return 受影响行数
     */
    int updateSpuAttrKeyById(@Param("id") Integer id , @Param("bo") SpuAttrKeyUpdate bo);


    /**
     * 删除选中的属性值
     * @param checked
     * @return 返回受影响的行数
     */
    int delSpuAttrValueById(@Param("checked") Integer[] checked);


    /**
     * 删除单个数据
     * @param id
     * @return 返回受影响行数
     */
    int delSpuAttrValueOne( @Param("id") Integer id);


    /**
     * 批量删除
     * @param checked
     * @return 返回受影响行数
     */
    int delSpuAttrValueMtu( @Param("checked") Integer[] checked);

    /**
     * 添加属性与分类的相关信息
     * @param cbo
     * @return 受影响行数
     */
    int addSpuSttrKeyCategories( @Param("cbo") SpuSttrKeyCategoriesAdd cbo);


    /**
     * 根据ID删除属性与分类的相关信息
     * @param id
     * @return 受影响行数
     */
    int delSpuSttrKeyCategoriesById(@Param("id") Integer id);

    /**
     * 根据选择ID数组删除属性与分类的相关信息
     * @param checked
     * @return 受影响行数
     */
    int delSpuSttrKeyCategoriesMtu(@Param("checked") Integer[] checked);


    /**
     * 根据名字查询是否存在
     * @param key_name
     * @return 受影响行数
     */

    Integer getIsExistByKeyName( @Param("key_name") String key_name );
}
