package problemOrder
import Item

class Order(val items: List<Item>) {
    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (item in items) {
            totalPrice += item.price
        }
        return totalPrice
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
    val items: List<Item> = listOf(Item(1.00), Item(2.50))
    val order: Order = Order(items=items)
    println(order.getTotalPrice())
}
