package main

import "fmt"

func main() {
	switch {
	case false:
		fmt.Println("Tomato")
	case (2 == 4):
		fmt.Println("Not Gonna print")
	case (3 == 3):
		fmt.Println("Printing")
	case (4 == 4):
		fmt.Println("Going to print?")
	default:
		fmt.Println("Default case")
	}

	fmt.Println("Falling Through.")
	switch {
	case false:
		fmt.Println("Tomato")
		fallthrough
	case (2 == 4):
		fmt.Println("Not Gonna print")
		fallthrough
	case (3 == 3):
		fmt.Println("Printing")
		fallthrough
	case (4 == 4):
		fmt.Println("Going to print?")
		fallthrough
	case (5 == 4):
		fmt.Println("Whaat")
		fallthrough
	case (20 == 20):
		fmt.Println("Thats a weird behavior")
	}

	fmt.Println("Value Switch")
	switch "José" {
	case "James":
		fmt.Println("Tomato")
	case "Bond", "José":
		fmt.Println("James Bond")
	}
}
