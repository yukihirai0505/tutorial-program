package practice

import (
	"fmt"
	"math"
)

type VS struct {
	X, Y float64
}

func (v VS) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func PrintMethod() {
	v := VS{3, 4}
	fmt.Println(v.Abs())
}
