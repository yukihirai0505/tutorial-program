package practice

import (
	"fmt"
)

func PrintDefer() {
	defer fmt.Println("world")
	fmt.Println("hello")
}

/***
* LIFO(last in first out)
 */
func PrintStackingDefers() {
	defer fmt.Println("counting")
	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}
	fmt.Println("done")
}
