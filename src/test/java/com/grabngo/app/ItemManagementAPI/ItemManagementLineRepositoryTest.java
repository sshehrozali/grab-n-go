package com.grabngo.app.ItemManagementAPI;

import com.grabngo.app.Internal.ItemManagementAPI.ItemManagementItemEntity;
import com.grabngo.app.Internal.ItemManagementAPI.ItemManagementLineEntity;
import com.grabngo.app.Internal.ItemManagementAPI.ItemManagementLineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ItemManagementLineRepositoryTest {

    @Autowired
    private ItemManagementLineRepository underTest;

    @Test
    void shouldDeleteItemByItem_id() {
        // Given
        ItemManagementItemEntity item = new ItemManagementItemEntity();
        item.setId("item1");
        item.setName("First Item");
        item.setDescription("Cool First Item");
        item.setCost(50);
        item.setPrice(100);

        ItemManagementLineEntity line = new ItemManagementLineEntity();
        line.setItem(item);
        line.setQuantity(10);
        underTest.save(line);

        // When
        underTest.deleteItemByItem_id(item.getId());
        ItemManagementLineEntity expected = underTest.findByItem_id(item.getId());

        // Then
        assertThat(expected).isNull();
    }

    @Test
    void shouldFindItemManagementLineEntityByItem_id() {
        // Given
        ItemManagementItemEntity item = new ItemManagementItemEntity();
        item.setId("item1");
        item.setName("First Item");
        item.setDescription("Cool First Item");
        item.setCost(50);
        item.setPrice(100);

        ItemManagementLineEntity line = new ItemManagementLineEntity();
        line.setItem(item);
        line.setQuantity(10);
        underTest.save(line);

        // When
        ItemManagementLineEntity expected = underTest.findByItem_id(item.getId());

        // Then
        assertThat(expected).isEqualTo(line);
    }
}