package practice

import "fmt"

func PrintFor() {
	sum := 0
	for i := 1; i <= 10; i++ {
		sum += i
	}
	fmt.Println(sum)
}

func PrintForContinued() {
	sum := 1
	for sum < 1000 {
		sum += sum
	}
	fmt.Println(sum)
}
