package practice

import "fmt"

func PrintSwap(x, y string) {
	a, b := swap(x, y)
	fmt.Println(a, b)
}

func swap(x, y string) (string, string) {
	return y, x
}
