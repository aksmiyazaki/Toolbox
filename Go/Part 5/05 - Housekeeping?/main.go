package main

import "fmt"
//var x int

type person struct {
	first string
	last string
}



//type foo int

//var y foo

func main()  {
	p1 := person{
		first: "James",
		last: "Bond",
	}

	fmt.Println(p1)
}