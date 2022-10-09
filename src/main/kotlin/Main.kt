import kotlin.math.sqrt
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) {
    val number = args[0].toInt()

    val mark = TimeSource.Monotonic.markNow()   // for Time check

    println()
    println("Find Primes under $number")

    val primeNumbers = (2..number)
        .filter { isPrime(it) }

    println("The Prime number Count is ${primeNumbers.size}")
    println()
    println(mark.elapsedNow())  // for Time check
}

// 1보다 큰 수 중에서 1과 자기 자신으로만 나누어 떨어지는 수
fun isPrime(number: Int): Boolean {
    if (number < 2)
        return false
    else if (number == 2)
        return true
    else if (number % 2 == 0)
        return false
    else {
        val rootOfNumber = sqrt(number.toDouble()).toInt()
        for (i in 3..rootOfNumber step (2)) {
            if (number % i == 0)
                return false
        }

        return true
    }
}