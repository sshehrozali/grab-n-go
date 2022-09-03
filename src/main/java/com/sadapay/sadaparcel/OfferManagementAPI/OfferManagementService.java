package com.sadapay.sadaparcel.OfferManagementAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferManagementService {

    @Autowired
    private OfferManagementRepository offerManagementRepository;
}
