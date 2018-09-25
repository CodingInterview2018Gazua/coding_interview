#include <gtest/gtest.h>
#include <stack_queue/42584.hpp>
using namespace STACK_QUEUE_42584;

TEST(stack_queue_42584, case1) {
	vector<int> prices{498,501,470,489};
	vector<int> expected{2,1,1,0};
	EXPECT_EQ(expected, solution(prices));
}

TEST(stack_queue_42584, case2) {
	vector<int> prices{1,2,3,4,5,4,3,2,1};
	vector<int> expected{ 8, 7, 5, 3, 1, 1, 1, 1, 0 };
	EXPECT_EQ(expected, solution(prices));
}
