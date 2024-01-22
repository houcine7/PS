package main

import (
	"container/list"
	"fmt"
)

type Dequeue struct {
	data *list.List
}

func NewDequeue() *Dequeue {
	return &Dequeue{data: list.New()}
}

// push to the queue
func (q *Dequeue) Push(val int) {

	for q.data.Len() != 0 && val > q.data.Back().Value.(int) {
		q.data.Remove(q.data.Back())
	}

	q.data.PushBack(val)
}

func (q *Dequeue) Pop(val int) {

	if q.data.Len() > 0 && q.Max() == val {
		q.data.Remove(q.data.Front())
	}
}

func (q *Dequeue) Max() int {
	return q.data.Front().Value.(int)
}

func maxSlidingWindow(nums []int, k int) []int {
	ans := []int{}
	dqueue := NewDequeue()

	for i, v := range nums {
		if i < k-1 {
			dqueue.Push(v)
			fmt.Println("inside if statements: ", dqueue.data)
		} else {
			dqueue.Push(v)
			ans = append(ans, dqueue.Max())
			dqueue.Pop(nums[i-k+1])
		}
	}

	return ans
}
