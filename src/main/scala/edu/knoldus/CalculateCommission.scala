package edu.knoldus

import scala.reflect.runtime.universe._

object CalculateCommission{
  sealed  trait CommissionDisplay {
    def totalDisplayCommission: String
  }

  implicit def calculateCommission[T <: Commission: TypeTag](commissionList: List[T]): String = {
    val total = commissionList.map(_.value).sum
    typeOf[List[T]] match {
      case typeOfList if typeOfList =:= typeOf[List[ClientSideCommission]] => s"The total client commission is: $total"
      case typeOfList if typeOfList =:= typeOf[List[StreetSideCommission]] => s"The total street commission is: $total"
      case typeOfList if typeOfList =:= typeOf[List[Commission]] => s"The total commission is: $total"
    }
  }


}

