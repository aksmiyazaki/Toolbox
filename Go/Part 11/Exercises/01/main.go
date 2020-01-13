package main

import (
	"encoding/json"
	"fmt"
	"log"
)

type person struct {
	First   string
	Last    string
	Sayings []string
}

func main() {
	p1 := person{
		First:   "James",
		Last:    "Bond",
		Sayings: []string{"Shaken, not stirred", "Any last wishes?", "Never say never"},
	}

	bs, ok := json.Marshal(p1)
	if ok != nil {
		log.Fatalln("There's error here: ", ok)
	} else {
		fmt.Println(string(bs))
	}

}
