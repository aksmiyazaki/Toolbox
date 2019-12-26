package main

import "fmt"

func main() {
	st := 33
	end := 122

	for st <= end {
		fmt.Printf("Value [%d] is from character [%#U])\n", st, st)
		st++
	}
}
