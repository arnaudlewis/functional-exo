package models

case class Trader(name: String, city: String)
case class Transaction(trader: Trader, year: Int, value: Int)