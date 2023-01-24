use shop;
alter table user
rename column userID to id;
alter table product
rename column productID to id;
alter table holiday
rename column holidayID to id;
alter table shop
rename column shopID to id;
alter table `order`
rename column orderID to id;
alter table orderdetails
rename column orderID to id;
alter table storage
rename column storageID to id;




