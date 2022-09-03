package com.sadapay.sadaparcel.OfferAPI;

import com.sadapay.sadaparcel.OfferManagementAPI.OfferManagementEntity;
import com.sadapay.sadaparcel.OfferManagementAPI.OfferManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OfferManagementRepository offerManagementRepository;
    public ResponseEntity<List<OfferManagementEntity>> getAllOffers() {
        return new ResponseEntity<>()
    }
}
