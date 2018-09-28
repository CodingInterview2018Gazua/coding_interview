#include <gtest/gtest.h>
#include <hash/42577.hpp>
using namespace HASH_42577;

TEST(hash_42577, case1) {
	vector<string> phone_book = {"119", "97674223", "1195524421"};
	bool expected = false;

	EXPECT_EQ(expected, solution(phone_book));
}

TEST(hash_42577, case2) {
	vector<string> phone_book = {"119", "456", "789"};
	bool expected = true;

	EXPECT_EQ(expected, solution(phone_book));
}

TEST(hash_42577, case3) {
	vector<string> phone_book = {"12", "123", "1235", "567", "88"};
	bool expected = false;

	EXPECT_EQ(expected, solution(phone_book));
}
