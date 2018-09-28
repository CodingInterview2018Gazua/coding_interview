#include <gtest/gtest.h>
#include <stack_queue/42586.hpp>
using namespace STACK_QUEUE_42586;

TEST(stack_queue_42586, case1) {
	vector<int> progresses{93,30,55};
	vector<int> speeds{1,30,5};
	vector<int> expected{2,1};
	EXPECT_EQ(expected, solution(progresses, speeds));
}
