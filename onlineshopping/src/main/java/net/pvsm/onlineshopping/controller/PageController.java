package net.pvsm.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.pvsm.shoppingbackend.dao.CategoryDAO;
import net.pvsm.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO catagoryDAO; 
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv= new ModelAndView("page");
		//passing list of category
		mv.addObject("categories",catagoryDAO.list());
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about" )
	public ModelAndView about(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact" )
	public ModelAndView contact(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	/*
	 * get all products
	 **/
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv= new ModelAndView("page");
		//passing list of category
		mv.addObject("categories",catagoryDAO.list());
		mv.addObject("title","All Products");
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id){
		ModelAndView mv= new ModelAndView("page");
		//fetch single category
		Category category= null;
		category=catagoryDAO.get(id);
				
		//passing list of category
		mv.addObject("categories",catagoryDAO.list());
		mv.addObject("title",category.getName());
		mv.addObject("userClickCategoryProducts",true);
		//passing category obj
		mv.addObject("category",category);
		return mv;
	}
	
	
}
