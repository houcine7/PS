package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// to string method for ListNode
func (l *ListNode) String() string {
	var result string
	for l != nil {
		result += fmt.Sprintf("%d -> ", l.Val)
		l = l.Next
	}
	return result
}

func reversListNode(head *ListNode) *ListNode {
	var prev *ListNode = nil
	current := head

	for current != nil {
		next := current.Next
		current.Next = prev
		prev = current
		current = next
	}

	return prev
}

func mergeTwoSortedArr(list1 *ListNode, list2 *ListNode) *ListNode {

	var dummy *ListNode = &ListNode{Val: -1}
	result := dummy
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			temp := &ListNode{
				Val: list1.Val,
			}
			list1 = list1.Next
			result.Next = temp
			result = temp
		} else {
			temp := &ListNode{
				Val: list2.Val,
			}
			list2 = list2.Next
			result.Next = temp
			result = temp
		}
	}

	for list1 != nil {
		temp := &ListNode{
			Val: list1.Val,
		}
		list1 = list1.Next
		result.Next = temp
		result = temp
	}

	for list2 != nil {
		temp := &ListNode{
			Val: list2.Val,
		}
		list2 = list2.Next
		result.Next = temp
		result = temp
	}

	return dummy.Next

}

func reorderList(list *ListNode) *ListNode {
	var arr = []*ListNode{}
	temp := list

	for temp != nil {
		arr = append(arr, temp)
		temp = temp.Next
	}

	fmt.Println("the temp array : ", arr)

	for start := 1; true; start++ {
		k := start
		v := len(arr) - start

		if k >= v {
			break
		}

		arr[k-1].Next = arr[v]
		arr[v].Next = arr[k]
	}

	arr[len(arr)/2].Next = nil

	return list

}

func inplaceReordering(head *ListNode) {
	fast, slow, temp := head, head, head

	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	curr := slow
	var prev *ListNode = nil

	for curr != nil {
		tmp := curr.Next
		curr.Next = prev
		prev = curr
		curr = tmp
	}

	p, q := temp, prev

	for temp != nil && prev != nil {
		p = p.Next
		q = q.Next
		temp.Next = prev
		prev.Next = p

		temp = p
		prev = q
	}
}

// test
func main() {
	list1 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
		},
	}

	list2 := &ListNode{
		Val: 2,
		Next: &ListNode{
			Val: 4,
		},
	}

	result := mergeTwoSortedArr(list1, list2)
	fmt.Println(result)
	result = reorderList(result)
	println(result.String())
}
