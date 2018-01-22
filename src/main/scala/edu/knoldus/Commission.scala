package edu.knoldus

abstract class Commission(val value: Int)


case class ClientSideCommission(override val value: Int) extends Commission(value)


case class StreetSideCommission(override val value: Int) extends Commission(value)


