package com.grabngo.app.Internal.ItemManagementAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemManagementItemRepository extends JpaRepository<ItemManagementItemEntity, String> {
}
