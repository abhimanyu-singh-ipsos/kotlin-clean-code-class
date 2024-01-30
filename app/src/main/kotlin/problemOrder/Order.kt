package problemOrder

import Item

// Exercise 2: What's wrong now?
// 1. total cost of items in one line - clever but hard to understand for people not familiar with collection functions
// 2. Item data class holds both the price and quantity of an item
// Should Item has the responsibility for tracking quantity of an item
class Order(val items: List<Item>) {
    val totalPrice: Double
        get() = {
            var totalCost = 0.0
            for (item in items) {
                val costOfItem = item.price * item.quantity
                totalCost += costOfItem
            }
            totalCost
        }()

    val deliveryPrice: Double
        get() = 2.5

    private val tax: Double
        get() = 20.0

    fun getPayablePrice(discount: Double): Double {
        var taxDue = totalPrice * (20 / 100)
        var discount = totalPrice * (discount / 100)
        return totalPrice - discount + taxDue + deliveryPrice
    }

}

fun run() {
    val items: List<Item> = listOf(
        Item(100.0, 2),
        Item(200.0, 3),
        Item(50.0, 4)
    )
    val order: Order = Order(items = items)
    println("The total price for your order is : ${order.totalPrice}")
    println("The payable price for your order is : ${order.getPayablePrice(15.00)}")
}

