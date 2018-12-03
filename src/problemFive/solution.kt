package problemFive

typealias f<T> = (T, T) -> T
typealias choice<T> = (f<T>) -> T

fun <T> cons(a: T, b: T): choice<T> {
    return fun(i: f<T>): T { return i(a, b) }
}

fun <T> car(f: choice<T>): T {
    return f(fun(a: T, b: T): T {
        return a
    })
}

fun <T> cdr(f: choice<T>): T {
    return f(fun(a: T, b: T): T {
        return b
    })
}

fun cons(x: Any, y: Any): Pair<Any, Any> {
    return Pair(x, y)
}

fun car(x: Pair<Any, Any>): Any {
    return x.first
}

fun cdr(x: Pair<Any, Any>): Any {
    return x.second
}