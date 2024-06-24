package team.tp_acsi_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.mail.internet.MimeMessage;

@Controller
public class ContactController {
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String handleContactForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {
        try {
            sendContactEmail(name, email, message);
            return "redirect:/contact?success";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/contact?error";
        }
    }

    private void sendContactEmail(String name, String email, String message) throws Exception {
        jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(email);
        helper.setTo("admin@example.com"); // Replace with your admin email address
        helper.setSubject("New Contact Message");
        helper.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);

        mailSender.send(mimeMessage);
    }
}