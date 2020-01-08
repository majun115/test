package com.majun.springMVC.controller;

import com.majun.springMVC.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class ItemController {

    @RequestMapping(value = "/itemList.action")
    public ModelAndView itemsView(){
        //springMVC中通过ModelAndView这个对象来表示模型与视图的一个对应关系
        ModelAndView view = new ModelAndView();
        //创建pojo集合
        ArrayList<Items> items = new ArrayList<Items>();
        //向集合中添加items信息
        items.add(new Items(1,"外星人",20000F,"我的电脑1",new Date()));
        items.add(new Items(2,"联想",10000F,"我的电脑2",new Date()));
        items.add(new Items(2,"苹果",15000F,"我的电脑3",new Date()));
        items.add(new Items(2,"谷歌",1000F,"我的电脑4",new Date()));
        //addObject相当于将数据封装到request域对象中
        view.addObject("itemList",items);
        //通过setViewName来指定我们要跳转的页面
        view.setViewName("/WEB-INF/jsp/itemList.jsp");
        return view;
    }
}
