package by.isb.an07.hw8.data.mappers
interface Mapper<F, T> {
    fun map(from: F): T
}