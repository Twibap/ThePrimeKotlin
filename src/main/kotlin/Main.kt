fun main(args: Array<String>) {
    val number = args[0].toInt()
    val primeNumbers = (2..number)
        .filter { isPrime(it) }
        .joinToString()

    println("The Prime number is ...")
    print(primeNumbers)
}

// 1보다 큰 수 중에서 1과 자기 자신으로만 나누어 떨어지는 수
fun isPrime(number: Int): Boolean {
    if (number < 2)
        return false
    else if (number == 2)
        return true
    else if (number % 2 == 0)
        return false
    else
        for (i in 3..number step(2)) {
            if (number % i == 0 && number != i)
                return false
            if (number % i == 0 && number == i)
                return true
        }

    return false
}