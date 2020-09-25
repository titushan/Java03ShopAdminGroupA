package com.bwf.shop.admin.controller;


import com.alibaba.fastjson.JSON;
import com.bwf.shop.admin.bean.bo.BrandAdd;
import com.bwf.shop.admin.bean.bo.BrandSearch;
import com.bwf.shop.admin.bean.bo.BrandUpdate;
import com.bwf.shop.admin.bean.po.Brand;
import com.bwf.shop.admin.bean.po.Category;
import com.bwf.shop.admin.service.IBrandService;
import com.bwf.shop.admin.service.ICategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {

    //依赖的业务逻辑层对象
    @Resource
    private IBrandService iBrandService;
    @Resource
    private ICategoryService iCategoryService;

    @RequestMapping("/admin")
    public String admin(Model model , BrandSearch bo){

        model.addAttribute("brandList" , iBrandService.getAllBrandList( bo ));
        int count = iBrandService.allTotal();
        // 根据 总记录数 和 每页显示的记录数 计算 总页数
        int total = count % bo.getLength() == 0 ?
                count / bo.getLength() :
                count / bo.getLength() + 1;
        // 控制 当前查询记录起始索引的范围
        if( bo.getStart() < 0 ){ bo.setStart(0); }
        if( bo.getStart() > (total - 1)*bo.getLength() ){ bo.setStart( (total - 1)*bo.getLength() ); }
        model.addAttribute("total" , total );
        model.addAttribute("bo",bo);
        return "brand/admin";
    }

    @RequestMapping("/add")
    public String add( Model model , Integer parent_id){

        model.addAttribute("categoryList1",iCategoryService.getAllCategoryListByParentId( null ));
        return null;
    }

    @RequestMapping("/getAllCategoryListByParentId")
    @ResponseBody
    public String getAllCategoryListByParentId( Integer parent_id){
        List<Category> categoryList = iCategoryService.getAllCategoryListByParentId( parent_id);
        String json = JSON.toJSONString(categoryList);
        return json;
    }

    @RequestMapping("/getBrandByName")
    @ResponseBody
    public String getBrandByName( String brand_name){


        System.out.println(1111);

        List<Brand> a = iBrandService.getBrandByName();

        String json = JSON.toJSONString(a);
        return json;

    }

    //品牌修改页面
    @RequestMapping("/update")
    public String update(Integer id , Model model){
        model.addAttribute("brand" , iBrandService.getOneBrandById( id));
        model.addAttribute("categoryList1",iCategoryService.getAllCategoryListByParentId( null ));
        return null;
    }

    //删除品牌
    @RequestMapping("/delete")
    public String delete( Integer id , Integer[] checked ,Model model){
        boolean resultRow = false;
        //判断删除一个还是多个
        if( id !=null ){
            //单个
            resultRow = iBrandService.deleteOne( id );
            System.out.println(resultRow);
        }
        if( checked != null ){
            //多个
            resultRow = iBrandService.deleteMtu( checked );
            System.out.println(resultRow);
        }
        if( resultRow ){
            System.out.println("删除成功！");
            model.addAttribute("messages",new String[]{"品牌删除执行成功！"});
            model.addAttribute("back","/brand/admin");
            return "common/success";
        }else{
            System.out.println("删除失败！");
            model.addAttribute("messages",new String[]{"品牌删除执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/brand/add");
            return "common/error";
        }
    }
    @RequestMapping("/save")
    public String save( BrandAdd bo , Model model){
        bo.setCreatetime( new Date(System.currentTimeMillis()));
        bo.setUpdatetime( new Date(System.currentTimeMillis()));
        //uuid生成文件名
        UUID uuid = UUID.randomUUID();
        String  brand_image_name= uuid.toString() + bo.getBrand_logourl_img().getOriginalFilename().substring( bo.getBrand_logourl_img().getOriginalFilename().lastIndexOf("."));
        String path = null;
        try {

            path = ResourceUtils.getURL("classpath:").getPath()+"static/img/";
            System.out.println(path );
            System.out.println("路径" +path);
            File brand_logourl_img = new File(path + brand_image_name);
            bo.getBrand_logourl_img().transferTo(brand_logourl_img);
            bo.setBrand_logourl( brand_image_name );
            System.out.println(brand_image_name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        boolean t2 =  iBrandService.addBrand(bo);

        if( t2 ){
            System.out.println("添加成功");
            model.addAttribute("messages",new String[]{"品牌添加执行成功！"});
            model.addAttribute("back","/brand/admin");
            return "common/success";
        }else{
            System.out.println("添加失败");
            model.addAttribute("messages",new String[]{"品牌添加执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/brand/add");
            return "common/error";
        }

    }
    @RequestMapping("/alter")
    public String alter(  BrandUpdate bo  ,Integer id , Model model){
        bo.setUpdatetime( new Date(System.currentTimeMillis()));

        //uuid生成文件名
        System.out.println(bo.getBrand_logourl_img().isEmpty());
        if(bo.getBrand_logourl_img().isEmpty()==false ){
            UUID uuid = UUID.randomUUID();
            String  brand_image_name= uuid.toString() + bo.getBrand_logourl_img().getOriginalFilename().substring( bo.getBrand_logourl_img().getOriginalFilename().lastIndexOf("."));
            String path = null;
            try {

                path = ResourceUtils.getURL("classpath:").getPath()+"static/img/";
                System.out.println(path );
                System.out.println("路径" +path);
                File brand_logourl_img = new File(path + brand_image_name);
                bo.getBrand_logourl_img().transferTo(brand_logourl_img);
                bo.setBrand_logourl( brand_image_name );
                System.out.println(bo.getBrand_logourl());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean t1 = iBrandService.updateBrandById( id ,bo);

        if( t1 ){
            System.out.println("修改成功");
            model.addAttribute("messages",new String[]{"品牌修改执行成功！"});
            model.addAttribute("back","/brand/admin");
            return "common/success";
        }else{
            System.out.println("修改失败");
            model.addAttribute("messages",new String[]{"品牌修改执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/brand/update");
            return "common/error";
        }

    }

}
