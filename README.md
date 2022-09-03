[//]: # (## Trade-offs)

[//]: # (3 September 2022: Now, after implementing `ItemAPI`, `ItemManagementAPI` and `OrderAPI` I have two choices to proceed with the exercise.)

[//]: # ()
[//]: # (Choice 1: Whether I should go start writing Tests for the implemented stuffs completed till date and start building more features like better Error Handling, Validations and Exceptional Handling.)

[//]: # ()
[//]: # (Choice 2: Go on implementing the last part of exercise i.e. `OfferAPI` and `OfferManagementAPI`so I will cover all the User stories and APIs. As )

<hr /> 

## Item Management API
### Database Diagram
![Item Management API Database schema](SadaParcel%20-%20ItemAPI__ItemManagementAPI.png "Title")

### `ItemManagementLineEntity`
![Item Management API - ItemManagementLineEntity](ItemManagementAPI%20-%20ItemManagementLineEntity.png "Title")

### `ItemManagementItemEntity`
![Item Management API - ItemManagementItemEntity](ItemManagementAPI%20-%20ItemManagementItemEntity.png "Title")

* #### GET
  Returns `List<ItemManagementLineEntity>`
* #### POST
  Accepts `@RequestBody` `List<ItemManagementLineEntity>`
* #### DELETE
  Accepts `@RequestBody` `ItemManagementDeleteModel` -> `List<Integer> itemIds`. Will delete all items with matching `itemIds.get()`

<hr />

## Item API
**No Entity created**.
* #### GET
  Uses `ItemManagementRepository` (internal) to query all offers. Maps each `ItemManagementLineEntity` (internal) to `ItemLineModel` (public) and returns `List<ItemLineModel>`

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

* #### GET
  Accepts `@RequestParam` `List<String> values`. Returns matching `List<OrderEntity>`
* #### POST
  Accepts `@ResquestBody` `List<OrderEntity>`

<hr />

## Offer Management API
### `OfferManagementEntity`
![Offer Management API - OfferManagementEntity](OfferManagementAPI%20-%20Entity.png "Title")

* #### GET
    Returns `List<OfferManagementEntity>`
* #### POST
    Accepts `@ResquestBody` `List<OfferManagementEntity>`
* #### DELETE
    Accepts `@RequestBody` `OfferManagementDeleteModel` -> `List<String> offerIds`

<hr />

## Offer API
**No Entity created**.
* #### GET
    Uses `OfferManagementRepository` (internal) to query all offers and returns `List<OfferManagementEntity>`

<hr />

[//]: # (# Trade-offs)

[//]: # ()
[//]: # (## Monolithic over Micro-services)

[//]: # (This is the no.1 trade-off, I felt while moving to finish Public Item API consumer package. The benefit I gained over following a monolithic architecture is that )

[//]: # (I can simply call `itemsManagementRepository.findAll&#40;&#41;` from `ItemsManagementAPI` package which is not a public API consumer package. Calling this method will simply return me a `List<ItemsManagementLineEntity>`. I can)

[//]: # (iterate over this `List`, create new `ItemModel`, call `ItemModel.set&#40;List<ith item>.get&#40;&#41;&#41;` and return `List<ItemModel>` to Public API consumer. This is because both Public and Internal consumers package lies within the same codebase. )