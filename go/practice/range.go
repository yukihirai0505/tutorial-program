package practice

import "fmt"

var arr = []int{1, 2, 4, 8, 16, 32, 64, 128}

func PrintRange() {
	for i, v := range arr {
		fmt.Printf("2**%d = %d\n", i, v)
	}
}
