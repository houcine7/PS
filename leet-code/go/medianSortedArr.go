package main

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	n := len(nums1)
	m := len(nums2)
	i, j := 0, 0
	var merged = []int{}
	for {
		if (n+m)%2 != 0 && len(merged) == (n+m)/2+1 {
			return float64(merged[(n+m)/2])
		}
		if (n+m)%2 == 0 && len(merged) == (n+m)/2+1 {
			return (float64(merged[(n+m)/2]) + float64(merged[(n+m)/2-1])) / 2
		}

		if i < n && j < m {
			if nums1[i] < nums2[j] {
				merged = append(merged, nums1[i])
				i++
			} else {
				merged = append(merged, nums2[j])
				j++
			}
			continue
		}

		if i < n {
			merged = append(merged, nums1[i])
			i++
		}

		if j < m {
			merged = append(merged, nums2[j])
			j++
		}
	}
}

func findMedianSortedArrays2(nums1 []int, nums2 []int) float64 {
	n, m := len(nums1), len(nums2)

	if (n+m)%2 == 0 {
		return (float64(solve(nums1, nums2, (n+m)/2, 0, n-1, 0, m-1)) +
			float64(solve(nums1, nums2, (n+m)/2-1, 0, n-1, 0, m-1))) / 2
	} else {
		return float64(solve(nums1, nums2, (n+m)/2, 0, n-1, 0, m-1))
	}
}

func solve(nums1 []int, nums2 []int, k, startA, endA, startB, endB int) int {

	if startA > endA {
		return nums2[k-startA]
	}

	if startB > endB {
		return nums1[k-startB]
	}

	midAIndex := startA + (endA-startA)/2
	midBIndex := startB + (endB-startB)/2

	midAVal := nums1[midAIndex]
	midBVal := nums2[midBIndex]

	if midBIndex+midAIndex < k {
		if midAVal > midBVal {
			return solve(nums1, nums2, k, startA, endA, midBIndex+1, endB)
		} else {
			return solve(nums1, nums2, k, midAIndex+1, endA, startB, endB)
		}
	} else {
		if midAVal > midBVal {
			return solve(nums1, nums2, k, startA, midAIndex-1, startB, endB)
		} else {
			return solve(nums1, nums2, k, startA, endA, startB, midBIndex-1)
		}
	}
}
