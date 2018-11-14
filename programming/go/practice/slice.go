package practice

import "fmt"

func PrintSlice() {
	names := [4]string{
		"John",
		"Paul",
		"George",
		"Ringo",
	}
	fmt.Println(names)

	a := names[0:2]
	b := names[1:3]
	fmt.Println(a, b)

	b[0] = "XXX"
	fmt.Println(a, b)
	fmt.Println(names)

	q := []int{2, 3, 5, 7, 11, 13}
	fmt.Println(q)
	r := []bool{true, false, true, true, false, true}
	fmt.Println(r)

	s := []struct {
		i int
		b bool
	}{
		{2, true},
		{3, false},
		{5, true},
		{7, true},
		{11, false},
		{13, true},
	}
	fmt.Println(s)

	printSlice(q)
	// Slice the slice to give it zero length
	q = q[:0]
	printSlice(q)
	// Extend its length
	q = q[:4]
	printSlice(q)
	// Frop its first two values
	q = q[2:]
	printSlice(q)

	q = append(q, 2, 3, 4, 5)
	printSlice(q)
}

func printSlice(s []int) {
	fmt.Printf("len=%d cap=%d %v\n", len(s), cap(s), s)
}
