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

    // Method that will return List of OfferManagementEntity from database
    public ResponseEntity<List<OfferManagementEntity>> getAllOffers() {
        return new ResponseEntity<>(offerManagementRepository.findAll(), HttpStatus.OK);
    }

    // Method that will upload all offers
    public ResponseEntity<List<OfferManagementEntity>> uploadAllNewOffers(List<OfferManagementEntity> offerManagementEntities) {
        return new ResponseEntity<>(offerManagementRepository.saveAll(offerManagementEntities), HttpStatus.OK);
    }

    // Method that will delete all offers from database by their Ids
    public ResponseEntity<OfferManagementDeleteModel> deleteAllOffersByIds(OfferManagementDeleteModel offerIdsToBeDeleted) {
        offerManagementRepository.deleteAllById(offerIdsToBeDeleted.getOfferIds()); // Delete all offers by their Ids
        return new ResponseEntity<>(offerIdsToBeDeleted, HttpStatus.OK);    // return 200 OK
    }
}
