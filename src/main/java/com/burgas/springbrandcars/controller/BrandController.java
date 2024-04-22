package com.burgas.springbrandcars.controller;

import com.burgas.springbrandcars.dao.BrandDao;
import com.burgas.springbrandcars.dao.CarDao;
import com.burgas.springbrandcars.model.Brand;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandDao brandDao;
    private final CarDao carDao;

    @Autowired
    public BrandController(BrandDao brandDao, CarDao carDao) {
        this.brandDao = brandDao;
        this.carDao = carDao;
    }

    @GetMapping
    public String brands(Model model) {
        model.addAttribute("brands", brandDao.findAll());
        return "brands/brands";
    }

    @GetMapping("/{id}")
    public String brand(@PathVariable("id") int id, Model model) {
        model.addAttribute("brand", brandDao.find(id));
        return "brands/brand";
    }

    @GetMapping("/{id}/cars")
    public String brandCars(@PathVariable("id") int id, Model model) {
        model.addAttribute("brand", brandDao.find(id));
        model.addAttribute("cars", carDao.findAll());
        return "brands/cars";
    }

    @GetMapping("/add")
    public String addBrandForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "brands/add";
    }

    @PostMapping("/add")
    public String addBrand(@ModelAttribute("brand") @Valid Brand brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "brands/add";
        }
        brandDao.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/{id}/edit")
    public String editBrandForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("brand", brandDao.find(id));
        return "brands/edit";
    }

    @PatchMapping("/{id}/edit")
    public String editBrand(@ModelAttribute("brand") @Valid Brand brand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "brands/edit";
        }
        brandDao.update(brand);
        return "redirect:/brands/{id}";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBrand(@ModelAttribute("brand") Brand brand) {
        brandDao.delete(brand);
        return "redirect:/brands";
    }
}
