package main

import "fmt"

func main() {
	for i := 1; i <= 10000; i++ {
		fmt.Println(i)
	}

	for i := 65; i <= 90; i++ {
		fmt.Println(i)
		for j := 0; j < 3; j++ {
			fmt.Printf("\t%#U\n", i)
		}
	}

	startAge := 1989

	for startAge < 2020 {
		fmt.Println("Alive in", startAge)
		startAge++
	}

	startAge = 1989

	for {
		if startAge == 2020 {
			break
		} else {
			fmt.Println(" 2 - Alive in", startAge)
			startAge++
		}
	}

	for i := 10; i <= 100; i++ {
		fmt.Println(i, i%4)
	}

	if 10 == 10 {
		fmt.Println("potato")
	}

	if 10 == 11 {
		fmt.Println("Potato")
	} else if 11 == 12 {
		fmt.Println("Tomato")
	} else {
		fmt.Println("Default")
	}

	switch {
	case false:
		fmt.Println("This never prints")
	case true:
		fmt.Println("Default of switch is true")
	}

	favSport := "soccer"

	switch favSport {
	case "soccer":
		fmt.Println("Value correct", favSport)
	case "voleyball":
		fmt.Println("Never print")
	default:
		fmt.Println("do not print")
	}

	fmt.Println(true && true)
	fmt.Println(true && false)
	fmt.Println(true || true)
	fmt.Println(true || false)
	fmt.Println(!true)
}
