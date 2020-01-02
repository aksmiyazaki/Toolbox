package main

import "fmt"

type person struct {
	first string
	last  string
}

type secretAgent struct {
	person
	ltk bool
}

func (s secretAgent) speak() {
	fmt.Println("I am", s.first, s.last)
}

func main() {
	p1 := secretAgent{
		person: person{
			first: "James",
			last:  "Bond",
		},
		ltk: true,
	}
	fmt.Println(p1)
	p1.speak()

	p2 := secretAgent{
		person: person{
			first: "Miss",
			last:  "Potato",
		},
		ltk: true,
	}
	fmt.Println(p2)
	p2.speak()

}
