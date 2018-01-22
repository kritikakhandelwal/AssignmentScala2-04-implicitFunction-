package edu.knoldus

import org.apache.log4j.Logger
import CONSTANTS._


object Application extends App {

  val log = Logger.getLogger(this.getClass)
  val totalCommission = new TotalCommission
  val clientCommission1 = ClientSideCommission(one)
  val clientCommission2 = ClientSideCommission(two)
  val clientCommissionList = List(clientCommission1, clientCommission2)
  val clientCommission = totalCommission.getTotalCommission[ClientSideCommission](clientCommissionList)
  log.info(clientCommission)

  val streetCommission1 =  StreetSideCommission(three)
  val streetCommissionList = List(streetCommission1)
  val streetCommission = totalCommission.getTotalCommission[StreetSideCommission](streetCommissionList)
  log.info("\n" + streetCommission)


  val mixedList = List(clientCommission1, streetCommission1)
  val commission = totalCommission.getTotalCommission[Commission](mixedList)
  log.info(s"\n$commission")
}
