[//]: # (## Trade-offs)

[//]: # (3 September 2022: Now, after implementing `ItemAPI`, `ItemManagementAPI` and `OrderAPI` I have two choices to proceed with the exercise.)

[//]: # ()
[//]: # (Choice 1: Whether I should go start writing Tests for the implemented stuffs completed till date and start building more features like better Error Handling, Validations and Exceptional Handling.)

[//]: # ()
[//]: # (Choice 2: Go on implementing the last part of exercise i.e. `OfferAPI` and `OfferManagementAPI`so I will cover all the User stories and APIs. As )

<hr /> 

## Order API
### Database diagram
![Order API Database schema](SadaParcel%20-%20Order%20API.png "Title")

### `OrderEnity`
![Order API - OrderEntity](OrderManagementAPI%20-%20OrderEntity.png "Title")

### `OrderItemEnity`
![Order API - OrderItemEntity](OrderManagementAPI%20-%20OrderItemEntity.png "Title")

### `OrderOfferEnity`
![Order API - OrderOfferEntity](OrderManagementAPI%20-%20OrderOfferEntity.png "Title")

### `OrderEntity` <--> `OrderItemEntity` (Relationship)
![Order API - ORDER_ORDER_ITEM](OrderManagementAPI%20-%20Relationship1.png "Title")

### `OrderEntity` <--> `OrderOfferEntity` (Relationship)
![Order API - ORDER_ORDER_OFFER](OrderManagementAPI%20-%20Relationship2.png "Title")

<hr />

## Offer Management API
### `OfferManagementEntity`
![Offer Management API - OfferManagementEntity](OfferManagementAPI%20-%20Entity.png "Title")

[//]: # (# Trade-offs)

[//]: # ()
[//]: # (## Monolithic over Micro-services)

[//]: # (This is the no.1 trade-off, I felt while moving to finish Public Item API consumer package. The benefit I gained over following a monolithic architecture is that )

[//]: # (I can simply call `itemsManagementRepository.findAll&#40;&#41;` from `ItemsManagementAPI` package which is not a public API consumer package. Calling this method will simply return me a `List<ItemsManagementLineEntity>`. I can)

[//]: # (iterate over this `List`, create new `ItemModel`, call `ItemModel.set&#40;List<ith item>.get&#40;&#41;&#41;` and return `List<ItemModel>` to Public API consumer. This is because both Public and Internal consumers package lies within the same codebase. )