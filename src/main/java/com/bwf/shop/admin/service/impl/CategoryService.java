package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.BrandCategories;
import com.bwf.shop.admin.bean.po.Category;
import com.bwf.shop.admin.mapper.CategoryMapper;
import com.bwf.shop.admin.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {



    @Resource
    private CategoryMapper categoryMapper;
    /**
     * 查询所有的分类
     * @return 分类列表
     */
    public List<Category> getAllCategoryListByParentId( Integer parent_id) {
        return categoryMapper.getAllCategoryListByParentId( parent_id  );
    }

    @Override
    public List<Category> getAllCategoryList(CategorySearch bo ) {
        return categoryMapper.getAllCategoryList( bo );
    }

    @Override
    public int getCategoryCount( CategorySearch bo ) {
        return categoryMapper.getCategoryCount( bo );
    }

    @Override
    public boolean delCategoryById(Integer id) {
        return categoryMapper.delCategoryById( id ) > 0;
    }

    @Override
    public boolean delCategoryMtu(Integer[] checked) {
        return categoryMapper.delCategoryMtu( checked ) > 0;
    }


    /**
     * 添加分类
     * @param bo
     * @return 是否添加成功
     */
    public boolean addCategory(CategoryAdd bo ){
        return categoryMapper.addCategory( bo ) > 0;
    }



    /**
     * 添加品牌分类的品牌id
     * @param bo
     * @return 是否成功
     */
    @Override
    public boolean addBrandCategory(CategoryAdd bo , Integer[] brand_id) {
        return categoryMapper.addBrandCategory( bo ,  brand_id) > 0;
    }

    @Override
    public boolean updateCateGoryById(Integer id , CategoryUpdate bo) {
        return categoryMapper.updateCateGoryById( id , bo ) > 0;
    }

    @Override
    public List<BrandCategories> getCategoryAndBrandByCategoryId(Integer id) {
        return categoryMapper.getCategoryAndBrandByCategoryId( id );
    }

    @Override
    public boolean updateCategoryAndBrand(Integer brand_id, Integer category_id) {
        return categoryMapper.updateCategoryAndBrand( brand_id , category_id ) > 0;
    }

    @Override
    public boolean delCategoryAndBrandById(Integer id) {
        return categoryMapper.delCategoryAndBrandById(id)>0;
    }



    /**
     * 根据名字查询是否存在
     * @param cate_name
     * @return 是否成功
     */
    @Override
    public boolean getCategoryByName(String cate_name) {
        return categoryMapper.getCategoryByName( cate_name) !=null;
    }

    @Override
    public boolean delBrandCategoryById(Integer id) {
        return categoryMapper.delBrandCategoryById( id ) > 0;
    }

    @Override
    public boolean delBrandCategoryMTU(Integer[] checked) {
        return categoryMapper.delBrandCategoryMTU(checked)>0;
    }

    @Override
    public boolean delSpuAttrKeyCategoryById(Integer id) {
        return categoryMapper.delSpuAttrKeyCategoryById(id)>0;
    }

    @Override
    public boolean delSpuAttrKeyCategories(Integer[] checked) {
        return categoryMapper.delSpuAttrKeyCategories(checked)>0;
    }


}
