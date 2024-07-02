package main

import "fmt"

type OrderedVector struct {
	capacity     int
	lastPosition int
	values       []int
}

func NewOrderedVector(capacity int) *OrderedVector {
	return &OrderedVector{
		capacity:     capacity,
		lastPosition: -1,
		values:       make([]int, capacity),
	}
}

func (ov *OrderedVector) Print() {
	if ov.lastPosition == -1 {
		fmt.Println("The vector is empty")
	} else {
		for i := 0; i <= ov.lastPosition; i++ {
			fmt.Printf("%d - %d\n", i, ov.values[i])
		}
	}
}

// O(n)
func (ov *OrderedVector) Insert(value int) {
	if ov.lastPosition == ov.capacity-1 {
		fmt.Println("Capacity reached")
		return
	}

	position := 0
	for i := 0; i <= ov.lastPosition; i++ {
		position = i
		if ov.values[i] > value {
			break
		}
		if i == ov.lastPosition {
			position = i + 1
		}
	}

	for x := ov.lastPosition; x >= position; x-- {
		ov.values[x+1] = ov.values[x]
	}

	ov.values[position] = value
	ov.lastPosition++
}

func main() {
	// Create an instance of OrderedVector with a capacity of 10
	ov := NewOrderedVector(10)

	// Insert values
	ov.Insert(3)
	ov.Insert(1)
	ov.Insert(4)
	ov.Insert(5)
	ov.Insert(8)

	// Print the vector
	ov.Print()
}
