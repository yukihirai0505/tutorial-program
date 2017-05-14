package practice

import "fmt"

type V struct {
	Lat, Long float64
}

var m map[string]V

func PrintMap() {
	m = make(map[string]V)
	m["Bell Labs"] = V{
		40.68433, -74.39967,
	}
	fmt.Println(m["Bell Labs"])
}
