package com.backendSmaileasy.ParkinlogicBackend.controller;

import com.backendSmaileasy.ParkinlogicBackend.entity.PersonPoliticasEntity;
import com.backendSmaileasy.ParkinlogicBackend.service.PersonPoliticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckUserPolicyController {

    private final PersonPoliticasService personPoliticasService;

    @Autowired
    public CheckUserPolicyController(PersonPoliticasService personPoliticasService) {
        this.personPoliticasService = personPoliticasService;
    }

    @GetMapping("/checkpolicy/{userId}/{facilityId}")
    public ResponseEntity<Boolean> checkUserPolicy(@PathVariable("userId") Integer userId,
                                                   @PathVariable("facilityId") Integer facilityId) {
        boolean hasAccepted = personPoliticasService.hasUserAcceptedPolicyForFacility(userId, facilityId);
        return new ResponseEntity<>(hasAccepted, HttpStatus.OK);
    }
}
