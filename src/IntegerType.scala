package decac

import scala.Math
import jllvm.LLVMType
import jllvm.LLVMIntegerType

abstract class IntegerRho(n: String,p: Option[IntegerRho]) extends PrimitiveRho {
  def signed: Boolean
  val name: String = n
  val parent: Option[IntegerRho] = p
  def floor: Int
  def ceiling: Int
  
  var compiledType: Option[LLVMIntegerType] = None
  
  val max_longnat = 2^64 - 1
  val max_longInt = 2^63 - 1
  val min_longInt = -2^63
  val max_nat = 2^32 - 1
  val max_Int = 2^31 - 1
  val min_Int = -2^31
  val max_snat = 2^16 - 1
  val max_sInt = 2^15 - 1
  val min_sInt = -2^15
  val max_byte = 2^8 - 1
  val max_octet = 2^7 - 1
  val min_octet = -2^7
  val min_unsigned = 0
  
  def compile: LLVMType = compiledType match {
    case None => {
      val myType = new LLVMIntegerType(Math.floor(Math.log(ceiling - floor) / Math.log(2)).toInt + 1)
      compiledType = Some(myType)
      return myType
    }
    case Some(myType) => myType
  }
  
  override def subtypes(tau: TauType,possibly: Boolean) = tau match {
    case itype: IntegerRho => parent match {
      case Some(par) => par == itype || par.subtypes(tau,possibly)
      case None => false
    }
    case range: RhoRange => subtypes(range.lowerBound,possibly)
    case _ => false
  }
}

object LongNat extends IntegerRho("longnat",None) {
  override def signed: Boolean = false
  override def floor: Int = min_unsigned
  override def ceiling: Int = max_longnat
}

object LongInt extends IntegerRho("longint",None) {
  override def signed: Boolean = true
  override def floor: Int = min_longInt
  override def ceiling: Int = max_longInt
}

object Nat extends IntegerRho("nat",Some(LongNat)) {
  override def ceiling: Int = max_nat
  override def floor: Int = min_unsigned
  override def signed: Boolean = false
}

object Int extends IntegerRho("int",Some(LongInt)) {
  override def floor: Int = min_Int
  override def ceiling: Int = max_Int
  override def signed: Boolean = true
}

object SNat extends IntegerRho("snat",Some(Nat)) {
  override def ceiling: Int = max_snat
  override def floor: Int = min_unsigned
  override def signed: Boolean = false
}

object SInt extends IntegerRho("sint",Some(Int)) {
  override def floor: Int = min_sInt
  override def ceiling: Int = max_sInt
  override def signed: Boolean = true
}

object Byte extends IntegerRho("byte",Some(SNat)) {
  override def floor: Int = min_unsigned
  override def ceiling: Int = max_byte
  override def signed: Boolean = false
}

object Octet extends IntegerRho("octet",Some(SInt)) {
  override def floor: Int = min_octet
  override def ceiling: Int = max_octet
  override def signed: Boolean = true
}
