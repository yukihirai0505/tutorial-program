package practice

import "fmt"

func PrintConstHello() {
	// const can't be declared by :=
	const Hello = "Hello"
	fmt.Println(Hello)
}
