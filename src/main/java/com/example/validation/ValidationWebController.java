package com.example.validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class ValidationWebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/validation/results").setViewName("formResults");
    }

    @GetMapping("/validation")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/validation")
    public String checkPersonInfo(@Valid PersonForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/validation/results";
    }
}
