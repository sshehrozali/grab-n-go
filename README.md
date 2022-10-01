[//]: # (## Trade-offs)

[//]: # (3 September 2022: Now, after implementing `ItemAPI`, `ItemManagementAPI` and `OrderAPI` I have two choices to proceed with the exercise.)

[//]: # ()
[//]: # (Choice 1: Whether I should go start writing Tests for the implemented stuffs completed till date and start building more features like better Error Handling, Validations and Exceptional Handling.)

[//]: # ()
[//]: # (Choice 2: Go on implementing the last part of exercise i.e. `OfferAPI` and `OfferManagementAPI`so I will cover all the User stories and APIs. As )

<hr /> 

# Public
## Item API
**No Entity created**.
* #### GET
  Uses `ItemManagementRepository` (internal) to query all offers. Maps each `ItemManagementLineEntity` (internal) to `ItemLineModel` (public) and returns `List<ItemLineModel>`

<hr />
### Master Database
![Master_DB](readme-images/Master_DB.png "Title")
<hr />

## Order API

### `OrderEnity`
![Order API - OrderEntity](readme-images/OrderManagementAPI%20-%20OrderEntity.png "Title")

### `OrderItemEnity`
![Order API - OrderItemEntity](readme-images/OrderManagementAPI%20-%20OrderItemEntity.png "Title")

### `OrderOfferEnity`
![Order API - OrderOfferEntity](readme-images/OrderManagementAPI%20-%20OrderOfferEntity.png "Title")

### `OrderEntity` <--> `OrderItemEntity` (Relationship)
![Order API - ORDER_ORDER_ITEM](readme-images/OrderManagementAPI%20-%20Relationship1.png "Title")

### `OrderEntity` <--> `OrderOfferEntity` (Relationship)
![Order API - ORDER_ORDER_OFFER](readme-images/OrderManagementAPI%20-%20Relationship2.png "Title")

* #### GET
  Accepts `@RequestParam` `List<String> values`. Returns matching `List<OrderEntity>`
* #### POST
  Accepts `@ResquestBody` `List<OrderEntity>`

<hr /> 

## Offer API
**No Entity created**.
* #### GET
  Uses `OfferManagementRepository` (internal) to query all offers and returns `List<OfferManagementEntity>`

<hr />

# Internal

## Item Management API
### `ItemManagementLineEntity`
![Item Management API - ItemManagementLineEntity](readme-images/ItemManagementAPI%20-%20ItemManagementLineEntity.png "Title")

### `ItemManagementItemEntity`
![Item Management API - ItemManagementItemEntity](readme-images/ItemManagementAPI%20-%20ItemManagementItemEntity.png "Title")

* #### GET
  Returns `List<ItemManagementLineEntity>`
* #### POST
  Accepts `@RequestBody` `List<ItemManagementLineEntity>`
* #### DELETE
  Accepts `@RequestBody` `ItemManagementDeleteModel` -> `List<Integer> itemIds`. Will delete all items with matching `itemIds.get()`

<hr />

## Offer Management API
### `OfferManagementEntity`
![Offer Management API - OfferManagementEntity](readme-images/OfferManagementAPI%20-%20Entity.png "Title")

* #### GET
    Returns `List<OfferManagementEntity>`
* #### POST
    Accepts `@ResquestBody` `List<OfferManagementEntity>`
* #### DELETE
    Accepts `@RequestBody` `OfferManagementDeleteModel` -> `List<String> offerIds`

<hr />


[//]: # (# Trade-offs)

[//]: # ()
[//]: # (## Monolithic over Micro-services)

[//]: # (This is the no.1 trade-off, I felt while moving to finish Public Item API consumer package. The benefit I gained over following a monolithic architecture is that )

[//]: # (I can simply call `itemsManagementRepository.findAll&#40;&#41;` from `ItemsManagementAPI` package which is not a public API consumer package. Calling this method will simply return me a `List<ItemsManagementLineEntity>`. I can)

[//]: # (iterate over this `List`, create new `ItemModel`, call `ItemModel.set&#40;List<ith item>.get&#40;&#41;&#41;` and return `List<ItemModel>` to Public API consumer. This is because both Public and Internal consumers package lies within the same codebase. )
