package io.github.David_Rn01.API_OFC.services;

import io.github.David_Rn01.API_OFC.dto.AlertDTO;
import io.github.David_Rn01.API_OFC.model.Alerts;
import io.github.David_Rn01.API_OFC.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertsService {

    @Autowired
    private AlertRepository alertRepository;

    public void SalvarAviso(AlertDTO alertDto){
        Alerts alert = new Alerts();

        alert.setTexto(alertDto.getTexto());

        alertRepository.save(alert);
    }
}
