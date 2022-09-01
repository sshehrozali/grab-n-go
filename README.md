# Trade-offs

## Monolithic over Micro-services
This is the no.1 trade-off, I felt while moving to finish Public Item API consumer package. The benefit I gained over following a monolithic architecture is that 
I can simply call `itemsManagementRepository.findAll()` from `ItemsManagementAPI` package which is not a public API consumer package. Calling this method will simply return me a `List<ItemsManagementLineEntity>`. I can
iterate over this `List`, create new `ItemModel`, call `ItemModel.set(List<ith item>.get())` and return `List<ItemModel>` to Public API consumer. This is because both Public and Internal consumers package lies within the same codebase. 