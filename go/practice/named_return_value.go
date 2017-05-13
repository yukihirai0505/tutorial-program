package practice

import "fmt"

func PrintSplit(sum int) {
	fmt.Println(split(sum))
}

func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return
}
