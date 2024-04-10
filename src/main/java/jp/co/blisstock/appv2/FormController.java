package jp.co.blisstock.appv2;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.blisstock.appv2.Model.Profile;
import jp.co.blisstock.appv2.Service.DbService;
import jp.co.blisstock.appv2.Service.UiService;

@Controller
public class FormController {
    UiService uiService;
    DbService dbService;

    public FormController(UiService uiService, DbService dbService) {
        this.uiService = uiService;
        this.dbService = dbService;
    }

    @GetMapping("/")
    public ResponseEntity<String> showForm() {
        return uiService.showForm();
    }

    @PostMapping("/submit")
    public String saveUser(@ModelAttribute("formData") FormData formData) throws SQLException {
        dbService.saveInfo(formData);
        return "redirect:/your-info?name=" + formData.getName();
    }

    @GetMapping("/your-info")
    public ResponseEntity<String> showInfo(@RequestParam("name") String name) throws SQLException {
        Profile profile = dbService.getInfo(name);
        return uiService.showResult(profile);
    }
}
