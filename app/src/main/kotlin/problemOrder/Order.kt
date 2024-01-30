package problemOrder

import Item

// Exercise: What's wrong with this code?
// 1. Repetition of code in calculating the prices
// 2. The Payable Price method is not clear - what is the 20% and 2.5 for?
// 3. The Order class does not tell but we need to ask
class Order(val items: List<Item>) {
    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (item in items) {
            totalPrice += item.price
        }
        return totalPrice
    }

    fun getPayablePrice(discount: Double): Double {
        var totalPrice = 0.0
        for (item in items) {
            totalPrice += item.price
        }
        return totalPrice - (totalPrice * (discount / 100)) + (totalPrice * (20 / 100)) + 2.5
    }

    fun getDiscountedPrice(discount: Double): Double {
        var totalPrice = 0.0
        for (item in items) {
            totalPrice += item.price
        }
        return totalPrice - (totalPrice * (discount / 100))
    }
}

fun run() {
    val items: List<Item> = listOf(Item(100.00), Item(250.00))
    val order: Order = Order(items = items)
    println("The total price for your order is : ${order.getTotalPrice()}")
    println("The discounted price for your order is : ${order.getDiscountedPrice(15.00)}")
    println("The payable price for your order is : ${order.getPayablePrice(15.00)}")
}
