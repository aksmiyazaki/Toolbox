package main

import "fmt"

func main() {

	// Empty switch == switch true
	switch {
	// Switch's default can go anywhere.
	default:
		fmt.Println("This should not print")
	case false:
		fmt.Println("Not Print")
	case true:
		fmt.Println("Printme")

	}
}
