package main

import "fmt"

type person struct {
	first string
	last  string
	age   int
}

type secretAgent struct {
	person
	first string
	ltk   bool
}

func main() {
	// Person components get promoted and can be used as <struct>.<field>
	p1 := secretAgent{
		person: person{
			first: "James",
			last:  "Bond",
			age:   33,
		},
		first: "potato",
		ltk:   true,
	}

	fmt.Println(p1)
	fmt.Println(p1.first, p1.person.first, p1.last, p1.age, p1.ltk)
}
