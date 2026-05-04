package io.github.David_Rn01.API_OFC.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Alert")
public class AlertController {

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarmsg(@RequestBody String text){
    
        return ResponseEntity.ok("aaaaa");
    }

}
