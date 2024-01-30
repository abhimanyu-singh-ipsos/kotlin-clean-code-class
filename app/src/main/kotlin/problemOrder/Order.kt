package problemOrder

import Item
import Inventory
import Customer
import PrintNotifier
// Exercise 3: What's wrong now?
class Order(val items: List<Inventory>, val customer: Customer) {
    val totalPrice: Double
        get() = {
            var totalCost = 0.0
            for (inventory in items) {
                val costOfItem = inventory.item.price * inventory.quantity
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

    fun createNotification(): String {
        return "Dear ${customer.name}, your order total is $totalPrice"
    }

}

fun run() {
    val items = listOf(
        Inventory(Item(100.0), 2),
        Inventory(Item(200.0), 3),
        Inventory(Item(50.0), 4)
    )
    val customer = Customer("Alice")
    val order: Order = Order(items = items, customer = customer)
    println("The total price for your order is : ${order.totalPrice}")
    println("The payable price for your order is : ${order.getPayablePrice(15.00)}")
    val printNotifier = PrintNotifier()
    printNotifier.notify(order.createNotification())
}

