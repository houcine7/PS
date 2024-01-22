package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {

	mapper := map[*Node]*Node{}
	temp := head

	for temp != nil {
		mapper[temp] = &Node{Val: temp.Val}
		temp = temp.Next
	}

	for k, v := range mapper {
		v.Next = mapper[k.Next]

		if k.Random != nil {
			v.Random = mapper[k.Random]
		}
	}
	// TODO : change this return value
	return mapper[head]
}
