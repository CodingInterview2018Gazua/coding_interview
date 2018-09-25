#include <gtest/gtest.h>
#include <stack_queue/42588.hpp>
using namespace STACK_QUEUE_42588;

TEST(stack_queue_42588, case1) {
	vector<int> heights{6,9,5,7,4};
	vector<int> expected{0,0,2,2,4};
	EXPECT_EQ(expected, solution(heights));
}

TEST(stack_queue_42588, case2) {
	vector<int> heights{3,9,9,3,5,7,2};
	vector<int> expected{0,0,0,3,3,3,6};
	EXPECT_EQ(expected, solution(heights));
}

TEST(stack_queue_42588, case3) {
	vector<int> heights{1,5,3,6,7,6,5};
	vector<int> expected{0,0,2,0,0,5,6};
	EXPECT_EQ(expected, solution(heights));
}
