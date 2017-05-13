package practice

import "fmt"

func PrintAdd(x int, y int) {
	fmt.Println(add(x, y))
}

func add(x, y int) int {
	return x + y
}
