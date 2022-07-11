package com.project.movietickets.service;

import com.project.movietickets.entity.TokenEntity;
import com.project.movietickets.entity.UserEntity;
import com.project.movietickets.model.Message;
import com.project.movietickets.repository.TokenRepository;
import com.project.movietickets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestorePasswordService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;

    public Message createToken(String username, String password, String rePassword) {
        Optional<UserEntity> optUserEntity = userRepository.findUserEntityByUsername(username);
        if (optUserEntity.isEmpty()) {
            return new Message(Message.ERROR, "Username không hợp lệ!");
        }

        if (!rePassword.equals(password)) {
            return new Message(Message.ERROR, "Nhập lại mật khẩu không trùng!");
        }

        TokenEntity tokenEntity = TokenEntity.builder()
                .isUsed(false)
                .username(username)
                .password(passwordEncoder.encode(password))
                .timeCreate(LocalDateTime.now())
                .token(UUID.randomUUID().toString())
                .build();

        tokenRepository.save(tokenEntity);
        sendEmail(optUserEntity.get().getEmail(),
                tokenEntity.getToken(),
                username
        );

        return new Message(Message.SUCCESS, "Bạn vào email để xác thực đặt lại mật khẩu!");
    }

    public void sendEmail(String email, String token, String username) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Khôi phục mật khẩu tài khoản HAC-Cinema");
        mailMessage.setFrom("HAC-Cinema");
        mailMessage.setTo(email);

        String content = "Mời bạn vào đường link http://localhost:8080/confirm-password?token="
                + token
                + " để đặt lại mật khẩu!";
        mailMessage.setText(content);

        javaMailSender.send(mailMessage);
    }

    public Message setNewPassword(String token){
        Optional<TokenEntity> optToken = tokenRepository.findTokenEntityByToken(token);
        if (optToken.isEmpty() || optToken.get().isUsed()){
            return new Message(Message.ERROR, "Token không hợp lệ!");
        }

        TokenEntity tokenEntity = optToken.get();
        String username = tokenEntity.getUsername();
        String password = tokenEntity.getPassword();

        Optional<UserEntity> optUser = userRepository.findUserEntityByUsername(username);
        if (optUser.isEmpty()){
            return new Message(Message.ERROR, "Token không hợp lệ!");
        }

        tokenEntity.setUsed(true);
        tokenRepository.save(tokenEntity);

        UserEntity user = optUser.get();
        user.setPassword(password);
        userRepository.save(user);

        return new Message(Message.SUCCESS, "Bạn đã đổi mật khẩu thành công!");
    }
}
