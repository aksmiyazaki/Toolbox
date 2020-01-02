package main

import (
	"fmt"
	"sort"
)

type user struct {
	First   string
	Last    string
	Age     int
	Sayings []string
}

type ByAge []user

func (ba ByAge) Len() int {
	return len(ba)
}

func (bs ByAge) Swap(i, j int) {
	bs[i], bs[j] = bs[j], bs[i]
}

func (bs ByAge) Less(i, j int) bool {
	return bs[i].Age < bs[j].Age
}

type ByLast []user

func (bl ByLast) Len() int {
	return len(bl)
}

func (bl ByLast) Swap(i, j int) {
	bl[i], bl[j] = bl[j], bl[i]
}

func (bl ByLast) Less(i, j int) bool {
	return bl[i].Last < bl[j].Last
}

func main() {
	u1 := user{
		First: "James",
		Last:  "Bond",
		Age:   32,
		Sayings: []string{
			"Shaken, not stirred",
			"Youth is no guarantee of innovation",
			"In his majesty's royal service",
		},
	}

	u2 := user{
		First: "Miss",
		Last:  "Moneypenny",
		Age:   27,
		Sayings: []string{
			"James, it is soo good to see you",
			"Would you like me to take care of that for you, James?",
			"I would really prefer to be a secret agent myself.",
		},
	}

	u3 := user{
		First: "M",
		Last:  "Hmmmm",
		Age:   54,
		Sayings: []string{
			"Oh, James. You didn't.",
			"Dear God, what has James done now?",
			"Can someone please tell me where James Bond is?",
		},
	}

	users := []user{u1, u2, u3}

	fmt.Println(users)

	fmt.Println("---------------")
	// your code goes here
	sort.Sort(ByAge(users))
	for _, v := range users {
		fmt.Println(v.First, "\t", v.Last, "\t", v.Age)
		for _, saying := range v.Sayings {
			fmt.Println("\t", saying)
		}
	}

	fmt.Println("---------------")
	sort.Sort(ByLast(users))
	for _, v := range users {
		fmt.Println(v.First, "\t", v.Last, "\t", v.Age)
		for _, saying := range v.Sayings {
			fmt.Println("\t", saying)
		}
	}
}
