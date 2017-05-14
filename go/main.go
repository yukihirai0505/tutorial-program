package main

import (
	"./practice"
)

func main() {
	practice.Hello()
	practice.PrintTime()
	practice.PrintAdd(1, 2)
	practice.PrintSwap("hello", "world")
	practice.PrintSplit(17)
	practice.PrintVariable()
	practice.PrintVariableWithInitialize()
	practice.PrintShortVariableDeclaration()
	practice.PrintConstHello()
	practice.PrintFor()
	practice.PrintForContinued()
	practice.PrintIf()
	practice.PrintIfWithShortStatement()
	practice.PrintSwitch()
	practice.PrintSwitchWithNoCondition()
	practice.PrintDefer()
	practice.PrintStackingDefers()
	practice.PrintPointer()
}
