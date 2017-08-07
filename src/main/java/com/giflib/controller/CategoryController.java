package com.giflib.controller;

import com.giflib.data.CategoryRepository;
import com.giflib.data.gifRepository;
import com.giflib.model.Category;
import com.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private gifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories = CategoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";

    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        modelMap.put("category", category);


        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs",gifs);
        return "category";
    }

}
