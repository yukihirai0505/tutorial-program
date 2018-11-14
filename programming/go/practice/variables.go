package practice

import "fmt"

var c, python, java bool

func PrintVariable() {
	var i int
	fmt.Println(i, c, python, java)
}

var i, j int = 1, 2

func PrintVariableWithInitialize() {
	var c, python, java = true, false, "no!"
	fmt.Println(i, j, c, python, java)
}

func PrintShortVariableDeclaration() {
	k := 3
	c, python, java := true, false, "no!"
	fmt.Println(k, c, python, java)
}
