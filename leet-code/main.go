package main

type ListNode struct {
	Val  int
	Next *ListNode
}

// to string method for ListNode
func (l *ListNode) String() string {
	var result string
	for l != nil {
		result += "${l.val}->"
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
	var arr []int = []int{}
	temp := list
	var i int = 0
	for temp != nil {
		arr = append(arr, list.Val)
		temp = temp.Next
		i++
	}

	var dummy *ListNode = &ListNode{Val: -1}

	result := dummy

	var l, r int = 0, len(arr) - 1

	for l < r {
		left_node := &ListNode{
			Val: arr[l],
			Next: &ListNode{
				Val: arr[r],
			},
		}
		result.Next = left_node
		result = left_node
	}

	return dummy.Next
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

	list1 = reversListNode(list1)
	list2 = reversListNode(list2)

	result := mergeTwoSortedArr(list1, list2)
	result = reversListNode(result)
	println(result.String())
}
