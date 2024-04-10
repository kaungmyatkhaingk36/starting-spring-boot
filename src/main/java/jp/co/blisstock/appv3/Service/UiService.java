package jp.co.blisstock.appv3.Service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jp.co.blisstock.appv3.Model.Profile;

@Service
public class UiService {
    public String showForm() {
        return "form";
    }

    public String showResult(Profile profile, Model model) {
        model.addAttribute("profile", profile);
        return "your-info";
    }
}
