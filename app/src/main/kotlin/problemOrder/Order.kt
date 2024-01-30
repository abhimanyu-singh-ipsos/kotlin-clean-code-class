package problemOrder

import Item

// After applying DRY, TDA, YAGNI
class Order(val items: List<Item>) {
    val totalPrice: Double
        get() = items.sumByDouble { it.price }

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
    val items: List<Item> = listOf(Item(100.00), Item(250.00))
    val order: Order = Order(items = items)
    println("The total price for your order is : ${order.totalPrice}")
    println("The payable price for your order is : ${order.getPayablePrice(15.00)}")
}
