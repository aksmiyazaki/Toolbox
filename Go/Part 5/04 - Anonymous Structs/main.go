package main

import "fmt"

func main() {
	p1 := struct {
		first string
		last  string
	}{
		first: "James",
		last:  "Bond",
	}

	fmt.Println(p1)
}
