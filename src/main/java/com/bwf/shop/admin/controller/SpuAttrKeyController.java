package com.bwf.shop.admin.controller;


import com.bwf.shop.admin.bean.bo.*;
import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.service.ICategoryService;
import com.bwf.shop.admin.service.ISpuAttrKeyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spuattrkey")
public class SpuAttrKeyController {

    @Resource
    private ISpuAttrKeyService iSpuAttrKeyService;

    @Resource
    private ICategoryService iCategoryService;

    @RequestMapping("/admin")
    public String admin(Model model , SpuAttrKeySearch bo){
        model.addAttribute("spuattrkeyList" , iSpuAttrKeyService.getAllSpuAttrKeyList( bo ) );
        int count = iSpuAttrKeyService.getSpuAttrKeyCount( bo );
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
        return null;
    }


    @RequestMapping("/add")
    public String add( Model model ){
        model.addAttribute("categoryByParentIdList" , iCategoryService.getAllCategoryListByParentId(null));

        return null;
    }

    @RequestMapping("/getIsExistByKeyName")
    @ResponseBody
    public boolean getIsExistByKeyName(  String key_name ){
        boolean a = iSpuAttrKeyService.getIsExistByKeyName(key_name);
        return a;
    }

    @RequestMapping("/save")
    public String save(SpuAttrKeyAdd bo , SpuAttrValueAdd vbo , String[] value_name , SpuSttrKeyCategoriesAdd cbo , Model model){
        boolean t2 ;
        int o = 0;
        bo.setCreatetime(new Date( System.currentTimeMillis()));
        bo.setUpdatetime(new Date(System.currentTimeMillis()));
        vbo.setCreatetime(new Date( System.currentTimeMillis()));
        vbo.setUpdatetime(new Date(System.currentTimeMillis()));
        boolean t1 = iSpuAttrKeyService.addSpuAttrKey( bo );
        System.out.println( value_name.length );
        for( int i = 0; i < value_name.length ; ++i ){
            vbo.setValue_name( bo.getValue_name()[i]);
            t2 = iSpuAttrKeyService.addSpuAttrValue( vbo , bo);
        }
        cbo.setCategory_id( bo.getCategory_id() );
        cbo.setSpu_attr_key_id( bo.getId());
        boolean t3 = iSpuAttrKeyService.addSpuSttrKeyCategories( cbo );

        if( t3 && t1){
            model.addAttribute("messages",new String[]{"属性添加执行成功！"});
            model.addAttribute("back","/spuattrkey/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"属性添加执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/spuattrkey/add");
            return "common/error";
        }

    }


    @RequestMapping("/delete")
    public String delete( Integer id ,Integer[] checked , Model model){
        boolean t1=false,t2=false;
        if( id != null ){
            iSpuAttrKeyService.delSpuAttrValueOne( id );
            iSpuAttrKeyService.delSpuSttrKeyCategoriesById(id);
            t1 = iSpuAttrKeyService.delSpuAttrKeyOne( id );
        }
        if( checked !=null){
            iSpuAttrKeyService.delSpuAttrValueMtu( checked );
            iSpuAttrKeyService.delSpuSttrKeyCategoriesMtu(checked);
            t2 = iSpuAttrKeyService.delSpuAttrKeyMtu( checked );
        }

        System.out.println(t1);
        System.out.println(t2);

        if( t1 ||  t2){
            model.addAttribute("messages",new String[]{"属性删除执行成功！"});
            model.addAttribute("back","/spuattrkey/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"属性删除执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/spuattrkey/update");
            return "common/error";
        }
    }

    @RequestMapping("/update")
    public String update( Integer id , Model model ){
        model.addAttribute("spuAttrValueList", iSpuAttrKeyService.getAllSpuAttrValueById(id));
        return null;

    }

    @RequestMapping("/alter")
    public String alter(Model model , SpuAttrKeyUpdate bo , Integer[] checked ,Integer id , SpuAttrValueAdd vbo ,SpuAttrKeyAdd kbo){
        boolean t1 = false , t2 = false , t3 = false;
        if( checked != null){
            iSpuAttrKeyService.delSpuAttrValueById( checked );
        }
        bo.setUpdatetime(new Date( System.currentTimeMillis()));
        if( !bo.getKey_name().isEmpty()){
            System.out.println(bo.getKey_name());
            iSpuAttrKeyService.updateSpuAttrKeyById(id , bo);
        }
        vbo.setCreatetime(new Date(System.currentTimeMillis()));
        vbo.setUpdatetime(new Date(System.currentTimeMillis()));
        for( int i =0 ; i < kbo.getValue_name().length ; ++ i){
            System.out.println(kbo.getValue_name()[i]);
            vbo.setValue_name( kbo.getValue_name()[i]);
            iSpuAttrKeyService.addSpuAttrValue( vbo , kbo);
        }

        if( t3 && t1 && t2){
            model.addAttribute("messages",new String[]{"属性更新执行成功！"});
            model.addAttribute("back","/spuattrkey/admin");
            return "common/success";
        }else{
            model.addAttribute("messages",new String[]{"属性更新执行失败！"});
            model.addAttribute("solution","请联系管理员！");
            model.addAttribute("back","/spuattrkey/update");
            return "common/error";
        }

    }





}
