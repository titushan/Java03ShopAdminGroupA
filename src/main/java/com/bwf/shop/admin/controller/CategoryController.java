package com.bwf.shop.admin.controller;

import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.BrandCategories;
import com.bwf.shop.admin.service.IBrandService;
import com.bwf.shop.admin.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService iCategoryService;

    @Resource
    private IBrandService iBrandService;


    @RequestMapping("/admin")
    public String admin(Model model , CategorySearch bo ){
        model.addAttribute("categoryByParentIdList" , iCategoryService.getAllCategoryListByParentId(null));
        model.addAttribute("categoryList" , iCategoryService.getAllCategoryList( bo ));
        int count = iCategoryService.getCategoryCount( bo );
        // 根据 总记录数 和 每页显示的记录数 计算 总页数
        if(count != 0){
            int total = count % bo.getLength() == 0 ?
                    count / bo.getLength() :
                    count / bo.getLength() + 1;
            // 控制 当前查询记录起始索引的范围
            if( bo.getStart() < 0 ){ bo.setStart(0); }
            if( bo.getStart() > (total - 1)*bo.getLength() ){ bo.setStart( (total - 1)*bo.getLength() ); }
            model.addAttribute("total" , total );
        }else{
            model.addAttribute("total" , 0 );
        }
        model.addAttribute("bo",bo);

        return "category/admin";
    }

    @RequestMapping("/add")
    public String add(Model model , BrandSearch bo) {

        model.addAttribute("categoryByParentIdList" , iCategoryService.getAllCategoryListByParentId(null));
        model.addAttribute("brandList" , iBrandService.getAllBrandList( bo ));
        return null;
    }
    @RequestMapping("/save")
    public String save( CategoryAdd bo ,Integer[] brand_id ,Model model ){
        bo.setCreatetime( new Date(System.currentTimeMillis()));
        boolean t1 = iCategoryService.addCategory( bo );

        if(brand_id != null){
            iCategoryService.addBrandCategory( bo , brand_id);
        }
        if( t1 ){
            model.addAttribute("messages",new String[]{"分类添加执行成功！"});
            model.addAttribute("back","/category/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"分类添加执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/category/add");
            return "common/error";
        }

    }


    @RequestMapping("/getCategoryByName")
    @ResponseBody
    public Boolean getCategoryByName( String cate_name ){
        boolean a = iCategoryService.getCategoryByName( cate_name);
        return a;
    }


    @RequestMapping("/alter")
    public String alter(Integer id , Integer[] brand_id ,Model model){
        boolean t3 = false;

        List<BrandCategories> bc = iCategoryService.getCategoryAndBrandByCategoryId( id );
        if(brand_id.length!=0){
            for( int j =0 ; j < bc.size() ; ++ j){
                iCategoryService.delCategoryAndBrandById( bc.get(j).getId() );
            }
        }
        for( int i = 1 ; i <= brand_id.length ; ++i) {
            System.out.println("brand_id=" +brand_id[i-1]);
            System.out.println("category"  + id);
            t3 = iCategoryService.updateCategoryAndBrand( brand_id[i-1],id);
       }
        if( t3 ){
            model.addAttribute("messages",new String[]{"分类修改执行成功！"});
            model.addAttribute("back","/category/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"分类修改执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/category/update");
            return "common/error";
        }

    }


    //删除
    @RequestMapping("/delete")
    public String delete( Integer id , Integer[] checked , Model model){
        boolean resultRow = false;
        //判断删除一个还是多个
        if( id !=null ){
            //单个
            iCategoryService.delBrandCategoryById(id);
            iCategoryService.delSpuAttrKeyCategoryById(id);
            resultRow = iCategoryService.delCategoryById( id );
        }
        if( checked != null ){
            //多个
            iCategoryService.delBrandCategoryMTU(checked);
            iCategoryService.delSpuAttrKeyCategories(checked);
            resultRow = iCategoryService.delCategoryMtu( checked );
        }
        if( resultRow ){
            System.out.println("删除成功！");
            model.addAttribute("messages",new String[]{"分类删除执行成功！"});
            model.addAttribute("back","/category/admin");
            return "common/success";
        }else{
            System.out.println("删除失败！");
            model.addAttribute("messages",new String[]{"分类删除执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/category/add");
            return "common/error";
        }
    }

    @RequestMapping("/update")
    public String update(Model model , BrandSearch bo ){
        model.addAttribute("categoryByParentIdList" , iCategoryService.getAllCategoryListByParentId(null));
        model.addAttribute("brandList" , iBrandService.getAllBrandList( bo ));
        return null;
    }
}
