package jp.co.blisstock.appv3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.blisstock.appv3.Model.Profile;
import jp.co.blisstock.appv3.Service.DbService;
import jp.co.blisstock.appv3.Service.UiService;

@Controller
public class FormController {
    UiService uiService;
    DbService dbService;

    public FormController(UiService uiService, DbService dbService) {
        this.uiService = uiService;
        this.dbService = dbService;
    }

    @GetMapping("/")
    public String showForm() {
        return uiService.showForm();
    }

    @PostMapping("/submit")
    public String saveUser(@ModelAttribute FormData formData) {
        dbService.saveInfo(formData);
        return "redirect:/your-info?name=" + formData.getName();
    }

    @GetMapping("/your-info")
    public String showInfo(@RequestParam("name") String name, Model model) {
        Profile profile = dbService.getInfo(name);
        return uiService.showResult(profile, model);
    }
}
