package main

import "fmt"

// Exer 3
const (
	ex3t  int = 10
	ex3ut     = 33.5
)

// Exer 6
const (
	_ = iota + 2019
	n1
	n2
	n3
	n4
)

func main() {
	x := 42

	// Exer 1
	fmt.Printf("%d\t%b\t%#X\n", x, x, x)

	// Exer 2
	// ==
	ex2 := 10 == 20
	fmt.Printf("10 == 20 \t%v\n", ex2)

	// <=
	ex2 = 10 <= 20
	fmt.Printf("10 <= 20 \t%v\n", ex2)

	// >=
	ex2 = 10 >= 20
	fmt.Printf("10 >= 20 \t%v\n", ex2)

	// !=
	ex2 = 10 != 20
	fmt.Printf("10 != 20 \t%v\n", ex2)

	// <
	ex2 = 10 < 20
	fmt.Printf("10 < 20 \t%v\n", ex2)

	// >
	ex2 = 10 > 20
	fmt.Printf("10 > 20 \t%v\n", ex2)

	// Exer 3
	fmt.Println(ex3t)
	fmt.Println(ex3ut)

	// Exer 4
	ex4a := 10
	fmt.Printf("EXER4 - %d\t%b\t%#X\n", ex4a, ex4a, ex4a)
	ex4a = ex4a << 1
	fmt.Printf("EXER4 - SHIFTED %d\t%b\t%#X\n", ex4a, ex4a, ex4a)

	// EXER 5
	ex5 := `I'm a raw \n string \t \t \r potato`
	fmt.Println(ex5)

	// Exer 6
	fmt.Println(n1, n2, n3, n4)
}
