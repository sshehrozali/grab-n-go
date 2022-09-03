package com.sadapay.sadaparcel.OfferManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferManagementService {

    @Autowired
    private OfferManagementRepository offerManagementRepository;

    public ResponseEntity<List<OfferManagementEntity>> uploadAllNewOffers(List<OfferManagementEntity> offerManagementEntities) {
        return new ResponseEntity<>(offerManagementRepository.saveAll(offerManagementEntities), HttpStatus.OK);
    }
}
