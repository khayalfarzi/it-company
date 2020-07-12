package az.company.itcompany.mailprocess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailSenderProcess {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email) throws MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Account activation");
        mimeMessageHelper.setText("Hi dear user, your activation link is here \n please tap to link.");

        String url = "http://localhost:8080/active?email=" + email + "&status=true";
        String content = "<a href='" + url + "'>" + url + "</a>";
        msg.setContent(" " + content, "text/html; charset=utf-8");

        javaMailSender.send(msg);
    }
}
