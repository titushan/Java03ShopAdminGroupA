package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.BrandAdd;
import com.bwf.shop.admin.bean.bo.BrandSearch;
import com.bwf.shop.admin.bean.bo.BrandUpdate;
import com.bwf.shop.admin.bean.po.Brand;
import com.bwf.shop.admin.bean.po.Category;
import com.bwf.shop.admin.mapper.BrandMapper;
import com.bwf.shop.admin.service.IBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 品牌模块的业务逻辑层实现类
 */
@Service
public class BrandService implements IBrandService {


    @Resource
    private BrandMapper brandMapper;
    @Override
    public List<Brand> getAllBrandList(BrandSearch bo) {
        return brandMapper.getAllBrandList(bo);
    }

    @Override
    public Brand getOneBrandById(Integer id) {
        return brandMapper.getOneBrandById(id);
    }


    @Override
    public boolean deleteOne(Integer id) {
        return brandMapper.deleteOne( id ) > 0;
    }

    @Override
    public boolean deleteMtu(Integer[] checked) {
        return brandMapper.deleteMtu( checked ) > 0;
    }

    @Override
    public int allTotal() {
        return brandMapper.allTotal();
    }

    @Override
    public boolean addBrand(BrandAdd bo) {
        return brandMapper.addBrand(bo) > 0;
    }
    @Override
    public boolean updateBrandById(Integer id, BrandUpdate bo) {
        return brandMapper.updateBrandById(id ,bo)> 0;
    }


    /**
     * 根据名字查询是否存在
     * @param
     * @return 是否存在
     */
    @Override
    public List<Brand> getBrandByName() {
        return brandMapper.getBrandByName(  ) ;
    }

}
