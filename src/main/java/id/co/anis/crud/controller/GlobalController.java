package id.co.anis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created By Anis
 * created on 3/28/2020 - 1:43 PM on crud
 */
@Controller
public class GlobalController {

    @GetMapping("/")
    public String index() {
        return "redirect:/students/list";
    }
}
