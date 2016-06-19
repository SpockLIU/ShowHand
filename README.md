# ShowHand
## This project is just for personal learn Java

This project is a show-hand game.

### 2016-6-10更新历史
2016-6-10 this is the 1.0 version. This version only can show cards.

### 2016-6-11更新记录
1. 2016-6-11 之前的版本全部写在一个class里面，操作起来非常困难，并且不符合JAVA面向对象的编程方法，故将所有的程序全部重写，之前的class也保持在ShowHand.java里面。
2. 采用了player, card, ShowCards, Poker，ShowHandGame五个类来实现。
3. 目前还只能自动发牌并比较大小，暂时还不能够与玩家互动。

### 2016-6-12更新记录
1. 完善了ShowHandCards.java中的fullhouse 及 two pairs的判定方法。
2. 将整个文档转到eclipse里面，发现采用gvim写一两个java文件还好，写到这种多个java文件的时候还是比较痛苦的。果断转到eclipse里面。

### 2016-6-19更新记录
1. 在Player里面增加了一些方法，可以实现每个player下注及跟进方法。
2. 将Players 写成一个list，进行统一管理。
3. 每轮先给上一轮牌最大的人发牌，然后最大牌的人来决定赌注，其他人来决定是否跟。如果某一轮只剩下一个人，则此人获胜，得到台面上所有的赌注。