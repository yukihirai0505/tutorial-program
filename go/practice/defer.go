package practice

import (
	"fmt"
)

func PrintDefer() {
	defer fmt.Println("world")
	fmt.Println("hello")
}
