package com.restApp.QuestionBankExam.controller;

import com.restApp.QuestionBankExam.model.Availability;
import com.restApp.QuestionBankExam.model.Capacity;
import com.restApp.QuestionBankExam.model.StoreInput;
import com.restApp.QuestionBankExam.model.StoreResponse;
import com.restApp.QuestionBankExam.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreResponse> getProductAvailability(@RequestBody StoreInput storeInput)
    {
        storeService.initializeAvailability();
        storeService.initializeCapacity();
        CompletableFuture<Availability> availabilityCompletableFuture=storeService.getAvailability(storeInput.getStoreNo());
        CompletableFuture<Capacity> capacityCompletableFuture=storeService.getCapacity(storeInput.getStoreNo());
        CompletableFuture.allOf(availabilityCompletableFuture,capacityCompletableFuture);
        String status=storeService.getStatus(storeInput);
        if(status !=null)
        {
            StoreResponse storeResponse=new StoreResponse(storeInput.getStoreNo(),storeInput.getProductId(),storeInput.getReqQty(),storeInput.getReqDate(),status);
            return new ResponseEntity<StoreResponse>(storeResponse, HttpStatus.OK);
        }
        else
            return new ResponseEntity<StoreResponse>(HttpStatus.NO_CONTENT);
    }

}
