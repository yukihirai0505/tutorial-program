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
	// it is like while statement
	for sum < 1000 {
		sum += sum
	}
	fmt.Println(sum)
}

func forever() {
	// if there is no condition, it is infinite loop.
	for {
	}
}
