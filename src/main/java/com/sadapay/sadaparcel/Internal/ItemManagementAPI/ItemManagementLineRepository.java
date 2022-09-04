package com.sadapay.sadaparcel.ItemManagementAPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemManagementLineRepository extends JpaRepository<ItemManagementLineEntity, Integer> {
    @Modifying  // to tell Spring that we are modifying a record in db, used with void/integer return type
    @Query("delete from ItemManagementLineEntity i where i.item.id=:id")
    void deleteItemByItem_id(String id);

    @Query("SELECT i FROM ItemManagementLineEntity i WHERE i.item.id=:id")
    ItemManagementLineEntity findByItem_id(String id);
}
