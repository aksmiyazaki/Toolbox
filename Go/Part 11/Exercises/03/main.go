package main

import "fmt"

type customErr struct {
	errCode  int
	errValue int
}

func (e customErr) Error() string {
	return fmt.Sprintf("Custom Error! : %v %v", e.errCode, e.errValue)
}

func main() {
	cerr := customErr{
		errCode:  42,
		errValue: 55,
	}
	foo(cerr)
}

func foo(err error) {
	fmt.Println("Received Error:", err.(customErr).errCode, err)
}
