package decac;

import jllvm.LLVMType
import jllvm.LLVMPointerType

class ReferenceRho(rho: RhoType,optional: Boolean) extends PrimitiveRho {
  val target: RhoType = rho
  val nullable: Boolean = optional
  
  override def subtypes(tau: TauType,possibly: Boolean): Boolean = tau match {
    case ref: ReferenceRho => target.subtypes(ref.target,possibly)
    case range: RhoRange => subtypes(range.lowerBound,possibly)
    case tvar: TauVariable => possibly
    case _ => false
  }
  
  override def compile: LLVMType = new LLVMPointerType(target.compile,0)
}
