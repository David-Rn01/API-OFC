package io.github.David_Rn01.API_OFC.services;

import io.github.David_Rn01.API_OFC.model.ListaPassageiros;
import io.github.David_Rn01.API_OFC.model.Student;
import io.github.David_Rn01.API_OFC.repository.ListRepository;
import io.github.David_Rn01.API_OFC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AddListService {

    @Autowired
    private StudentRepository estudentRepository;

    @Autowired
    private ListRepository listRepository;

    public String addInList(UUID idAluno){
        ListaPassageiros lista = new ListaPassageiros();
        Student aluno = estudentRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno não encontrado " ));

        boolean jaExiste = listRepository.existsByStudent(aluno);
        if (jaExiste){
            return "Aluno já está na lista de passageros";
        }

        lista.setStudent(aluno);
        lista.setName(aluno.getName());
        lista.setCity(aluno.getCity());
        lista.setDestiny(aluno.getSchool());

        listRepository.save(lista);

        return "Aluno adicionado a lista de passageiros";
    }
}
