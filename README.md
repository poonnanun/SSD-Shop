# SSD-Shop

## About this application

&nbsp;&nbsp;&nbsp;This is a program that is a minimize version of POS of the Grocery store.
        
#### Feature

- Shop owner can store the data of item in the store.
- Shop owner can set own promotion to each item such as buy 1 get 2.
- Cashier can get the total price just by inputting the item id and its quantities.

## Design patterns

#### Singleton
- This design pattern use in shopping cart so that cart has create only one time then it clean and reuse for reduce the memory.


#### Strategy
- This design pattern use for the promotion class which have many kind of promotion such as discount or buy 1 get 1.


#### ObjectPool
- This design pattern use for the item list in the store in case if that store have a lot of item so it'll just load from the memory just 1 time when in buying mode for increasing of performance.

## How to use
This program is run on command line so there won't be any gui.

1) Run the program file by run main.java.

2) Type the letter to go to each feature.

3) Add feature system will ask you to input the name and price.

4) Buy feature input the id of item that customer buy and the quantities of it and input 0 if that is all of item. then input the amount of money that customer pay.

5) Promotion feature is use for config the promotion of item by select the id of item and select the type of promotion then input the condition and the amount of promotion.

6) Remove feature is use for remove the item is the database by select the id of item.

## Contributor

Create by **MR. Poonnanun Poonnopathum 6010546699** 