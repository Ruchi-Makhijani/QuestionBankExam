package com.restApp.QuestionBankExam.controller;

import com.restApp.QuestionBankExam.model.DemandInput;
import com.restApp.QuestionBankExam.model.DemandResponse;
import com.restApp.QuestionBankExam.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping("/getAvailability")
    public ResponseEntity<DemandResponse> getAvailability(@RequestBody DemandInput demandInput)
    {
        demandService.initializeDemand();
        demandService.initializeSupply();
        double availability = demandService.getAvailability(demandInput.getProductId());
        if(availability!=0)
        {
            DemandResponse demandResponse=new DemandResponse(demandInput.getProductId(),availability);
            return new ResponseEntity<DemandResponse>(demandResponse,HttpStatus.OK);
        }
        return new ResponseEntity<DemandResponse>(HttpStatus.NO_CONTENT);
    }

}
