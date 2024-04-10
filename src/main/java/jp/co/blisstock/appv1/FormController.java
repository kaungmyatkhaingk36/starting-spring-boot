package jp.co.blisstock.appv1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("/")
    public ResponseEntity<String> showForm() {
        String formHtml = "<!DOCTYPE html>\n"
                + "<html lang=\"en\" >\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Form</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <form action=\"/your_info\" method=\"post\">\n"
                + "        <label>Name:</label>\n"
                + "        <input type=\"text\" name=\"name\"><br>\n"
                + "        <label>Age:</label>\n"
                + "        <input type=\"text\" name=\"age\"><br>\n"
                + "        <label>Gender:</label>\n"
                + "        <input type=\"text\" name=\"gender\"><br>\n"
                + "        <label>Occupation:</label>\n"
                + "        <input type=\"text\" name=\"occupation\"><br>\n"
                + "        <label>Email:</label>\n"
                + "        <input type=\"text\" name=\"email\"><br>\n"
                + "        <button type=\"submit\">Submit</button>\n"
                + "    </form>\n"
                + "</body>\n"
                + "</html>";
        return ResponseEntity.ok(formHtml);
    }

    @PostMapping("/your_info")
    public ResponseEntity<String> showInfo(@ModelAttribute FormData formData) {
        String resultHtml = String.format("<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <title>Result</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <h2>Submitted Data</h2>\n"
                + "    <p>Name: %s</p>\n"
                + "    <p>Age: %s</p>\n"
                + "    <p>Gender: %s</p>\n"
                + "    <p>Occupation: %s</p>\n"
                + "    <p>Email: %s</p>\n"
                + "</body>\n"
                + "</html>",
                formData.getName(),
                formData.getAge(),
                formData.getGender(),
                formData.getOccupation(),
                formData.getEmail());

        return ResponseEntity.ok(resultHtml);
    }

}
