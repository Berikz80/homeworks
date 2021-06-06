package by.isb.an07
interface Mapper<F, T> {
    fun map(from: F): T
}