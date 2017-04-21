# springboot-dubbo-tcc-demo

This is a tcc transaction sample using spring boot, dubbo.

## How to run?
1. import all modules by importing module "root"
2. create db and import sql scripts in folder "docs"
3. run zookeeper locally.
4. run app capital by running "AppCapital.java" in module "service_capital"
5. run app redpacket by running "AppRedPacket.java" in module "service_redpacket"
6. run app orders by running "AppOrders.java" in module "orders"
7. visit "http://localhost:8088/order"

- if can not find maven dependency about tcc-transaction, get it form "https://github.com/changmingxie/tcc-transaction"

## Reference and more dscription
- https://github.com/changmingxie/tcc-transaction
- https://github.com/changmingxie/tcc-transaction/wiki/%E4%BD%BF%E7%94%A8%E6%8C%87%E5%8D%97
