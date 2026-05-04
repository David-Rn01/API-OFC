package io.github.David_Rn01.API_OFC.services;

import io.github.David_Rn01.API_OFC.model.Student;
import io.github.David_Rn01.API_OFC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    StudentRepository student;

    public boolean login(String email, String password){
        Student user = student.findByEmail(email);

        if (user == null) return false;

        return encoder.matches(password, user.getPassword());
    }
}
