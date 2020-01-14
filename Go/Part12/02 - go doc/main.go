package main

import (
	"fmt"
	"/Users/alexandre.miyazaki/Documents/git-personal/Toolbox/Go/Part 12/02 - go doc/mymath"
)

func main() {
	fmt.Println("2 + 3 =", mymath.Sum(2, 3))
	fmt.Println("4 + 7 =", mymath.Sum(4, 7))
	fmt.Println("5 + 9 =", mymath.Sum(5, 9))
}