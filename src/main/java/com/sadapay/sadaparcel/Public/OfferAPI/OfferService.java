package com.sadapay.sadaparcel.Public.OfferAPI;

import com.sadapay.sadaparcel.Internal.OfferManagementAPI.OfferManagementEntity;
import com.sadapay.sadaparcel.Internal.OfferManagementAPI.OfferManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OfferManagementRepository offerManagementRepository;

    // Method that will return all available offers from database
    public ResponseEntity<List<OfferManagementEntity>> getAllOffers() {
        return new ResponseEntity<>(offerManagementRepository.findAll(), HttpStatus.OK);
    }
}