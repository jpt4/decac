/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.40
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.jllvm.bindings;

class ScalarJNI {
  public final static native void LLVMAddAggressiveDCEPass(long jarg1);
  public final static native void LLVMAddCFGSimplificationPass(long jarg1);
  public final static native void LLVMAddDeadStoreEliminationPass(long jarg1);
  public final static native void LLVMAddGVNPass(long jarg1);
  public final static native void LLVMAddIndVarSimplifyPass(long jarg1);
  public final static native void LLVMAddInstructionCombiningPass(long jarg1);
  public final static native void LLVMAddJumpThreadingPass(long jarg1);
  public final static native void LLVMAddLICMPass(long jarg1);
  public final static native void LLVMAddLoopDeletionPass(long jarg1);
  public final static native void LLVMAddLoopIndexSplitPass(long jarg1);
  public final static native void LLVMAddLoopRotatePass(long jarg1);
  public final static native void LLVMAddLoopUnrollPass(long jarg1);
  public final static native void LLVMAddLoopUnswitchPass(long jarg1);
  public final static native void LLVMAddMemCpyOptPass(long jarg1);
  public final static native void LLVMAddPromoteMemoryToRegisterPass(long jarg1);
  public final static native void LLVMAddReassociatePass(long jarg1);
  public final static native void LLVMAddSCCPPass(long jarg1);
  public final static native void LLVMAddScalarReplAggregatesPass(long jarg1);
  public final static native void LLVMAddSimplifyLibCallsPass(long jarg1);
  public final static native void LLVMAddTailCallEliminationPass(long jarg1);
  public final static native void LLVMAddConstantPropagationPass(long jarg1);
  public final static native void LLVMAddDemoteMemoryToRegisterPass(long jarg1);
}
