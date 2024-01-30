import Notifier
class PrintNotifier: Notifier {
    override fun notify(message: String) {
        println(message)
    }
}
