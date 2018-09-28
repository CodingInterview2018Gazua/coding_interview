#include <gtest/gtest.h>
#include <stack_queue/42585.hpp>
using namespace STACK_QUEUE_42585;

TEST(stack_queue_42585, case1) {
	string arrangement = "()(((()())(())()))(())";
	int expected = 17;
	EXPECT_EQ(expected, solution(arrangement));
}
