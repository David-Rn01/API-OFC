package io.github.David_Rn01.API_OFC.services;

import io.github.David_Rn01.API_OFC.dto.DriverRegistrationDTO;
import io.github.David_Rn01.API_OFC.dto.DriverResponseDTO;
import io.github.David_Rn01.API_OFC.dto.StudentRegistrationDTO;
import io.github.David_Rn01.API_OFC.dto.StudentResponseDTO;
import io.github.David_Rn01.API_OFC.model.Driver;
import io.github.David_Rn01.API_OFC.model.Role;
import io.github.David_Rn01.API_OFC.model.Student;
import io.github.David_Rn01.API_OFC.repository.DriverRepository;
import io.github.David_Rn01.API_OFC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServices {

    //NÃO É NECESSÁRIO CRIAR UM SERVICE PARA CADA ROLE, POIS NO CONTROLER DEPENDENDO DO CAMINHA DA REQUISIÇÃO
    // É APENAS CHAMAR UMA FUNÇÃO DIFERENTE

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DriverRepository driverRepository;

    //Usa o DTO que recebe os parâmetros pelo corpo da requisição recebida lá no controller
    public StudentResponseDTO registerStudant(StudentRegistrationDTO registrationDTO) {
        //Converter o DTO para entidade
        Student student = new Student();

        if (studentRepository.existsByCpf(registrationDTO.getCpf())){
            throw new RuntimeException("CPF já cadastrado");
        }

        student.setName(registrationDTO.getName());
        student.setEmail(registrationDTO.getEmail());
        student.setCpf(registrationDTO.getCpf());
        student.setCity(registrationDTO.getCity());
        student.setSchool(registrationDTO.getSchool());
        student.setNumber(registrationDTO.getNumber());

        //criptografa a senha
        student.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        student.setRole(Role.STUDENT);

        Student savedStudent = studentRepository.save(student);

        return convertToStudentResponseDTO(savedStudent);
    }

    //DTO de retorno para registro de aluno, não retorna dados sensíveis
    private StudentResponseDTO convertToStudentResponseDTO(Student student){
        StudentResponseDTO response = new StudentResponseDTO();

        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setCity(student.getCity());
        response.setSchool(student.getSchool());
        response.setNumber(student.getNumber());
        response.setRole(student.getRole());

        return response;
    }

    // ========================================================== DRIVER REGISTER BELLOW =========================================================================

    public DriverResponseDTO registerDriver(DriverRegistrationDTO registerData){
        Driver driver = new Driver();

        boolean jaExiste = driverRepository.existsByConductionNumber(registerData.getConductionNumber());
        if (jaExiste){
            throw new RuntimeException("Motorista já cadastrado");
        }

        driver.setName(registerData.getName());
        driver.setEmail(registerData.getEmail());
        driver.setNumber(registerData.getNumber());
        driver.setConductionNumber(registerData.getConductionNumber());
        driver.setCity(registerData.getCity());
        driver.setPlate(registerData.getPlate());
        driver.setRole(Role.DRIVER);
        //criptografa a senha recebida do register data
        driver.setPassword(passwordEncoder.encode(registerData.getPassword()));

        Driver savedDriver = driverRepository.save(driver);

        return convertToDriverResponseDTO(savedDriver);
    }

    private DriverResponseDTO convertToDriverResponseDTO(Driver driver){
        DriverResponseDTO response = new DriverResponseDTO();

        response.setCity(driver.getCity());
        response.setPlate(driver.getPlate());
        response.setName(driver.getName());
        response.setNumber(driver.getNumber());
        response.setEmail(driver.getEmail());
        response.setConductionNumber(driver.getConductionNumber());
        response.setRole(driver.getRole());

        return response;
    }
}
