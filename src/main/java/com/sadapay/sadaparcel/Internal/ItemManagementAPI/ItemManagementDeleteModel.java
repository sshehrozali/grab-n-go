package com.sadapay.sadaparcel.Internal.ItemManagementAPI;

import lombok.Data;

import java.util.List;

@Data
public class ItemManagementDeleteModel {
    private List<String> itemIds;
}
