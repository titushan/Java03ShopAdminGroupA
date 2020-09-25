package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import com.bwf.shop.admin.mapper.SpuAttrKeyMapper;
import com.bwf.shop.admin.service.ISpuAttrKeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {

    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;

    @Override
    public List<SpuAttrKey> getAllSpuAttrKeyList(SpuAttrKeySearch bo) {
        return spuAttrKeyMapper.getAllSpuAttrKeyList( bo );
    }


    /**
     * 查询总记录数
     * @return 总记录数
     */
    @Override
    public int getSpuAttrKeyCount( SpuAttrKeySearch bo ) {
        return spuAttrKeyMapper.getSpuAttrKeyCount(bo);
    }

    @Override
    public boolean delSpuAttrKeyOne(Integer id) {
        return spuAttrKeyMapper.delSpuAttrKeyOne( id )>0;
    }

    @Override
    public boolean delSpuAttrKeyMtu(Integer[] checked) {
        return spuAttrKeyMapper.delSpuAttrKeyMtu( checked ) > 0;
    }



    /**
     * 添加属性值
     * @param bo
     * @return 是否成功
     */
    @Override
    public boolean addSpuAttrKey(SpuAttrKeyAdd bo) {
        return spuAttrKeyMapper.addSpuAttrKey( bo ) > 0;
    }


    /**
     * 添加属性值
     * @param vbo
     * @return 是否成功
     */
    @Override
    public boolean addSpuAttrValue(SpuAttrValueAdd vbo , SpuAttrKeyAdd kbo ) {
        return spuAttrKeyMapper.addSpuAttrValue( vbo , kbo ) >0;
    }


    /**
     * 根据id查询属性已经存在的属性值
     * @param id
     * @return 已经存在的属性值
     */
    @Override
    public List<SpuAttrValue> getAllSpuAttrValueById( Integer id ) {
        return spuAttrKeyMapper.getAllSpuAttrValueById( id );
    }


    /**
     * 修改属性
     * @param id bo
     * @return 受影响行数
     */
    @Override
    public boolean updateSpuAttrKeyById(Integer id, SpuAttrKeyUpdate bo) {
        return spuAttrKeyMapper.updateSpuAttrKeyById(id ,bo ) > 0;
    }



    /**
     * 删除选中的属性值
     * @param checked
     * @return 是否成功
     */
    @Override
    public boolean delSpuAttrValueById(Integer[] checked) {
        return spuAttrKeyMapper.delSpuAttrValueById( checked ) > 0;
    }

    @Override
    public boolean delSpuAttrValueOne(Integer id) {
        return spuAttrKeyMapper.delSpuAttrValueOne( id ) > 0;
    }

    @Override
    public boolean delSpuAttrValueMtu(Integer[] checked) {
        return spuAttrKeyMapper.delSpuAttrValueMtu(checked) > 0;
    }



    /**
     * 添加属性与分类的相关信息
     * @param cbo
     * @return  是否成功
     */
    @Override
    public boolean addSpuSttrKeyCategories(SpuSttrKeyCategoriesAdd cbo) {
        return spuAttrKeyMapper.addSpuSttrKeyCategories( cbo ) > 0;
    }


    /**
     * 根据ID删除属性与分类的相关信息
     * @param id
     * @return 是否成功
     */
    @Override
    public boolean delSpuSttrKeyCategoriesById(Integer id) {
        return spuAttrKeyMapper.delSpuSttrKeyCategoriesById( id )>0;
    }


    /**
     * 根据选择ID数组删除属性与分类的相关信息
     * @param checked
     * @return 是否成功
     */
    @Override
    public boolean delSpuSttrKeyCategoriesMtu(Integer[] checked) {
        return spuAttrKeyMapper.delSpuSttrKeyCategoriesMtu( checked) > 0;
    }



    /**
     * 根据名字查询是否存在
     * @param key_name
     * @return 受影响行数
     */
    @Override
    public boolean getIsExistByKeyName(String key_name) {
        return spuAttrKeyMapper.getIsExistByKeyName( key_name ) !=null;
    }
}
