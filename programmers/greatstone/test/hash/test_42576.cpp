#include <gtest/gtest.h>
#include <hash/42576.hpp>
using namespace HASH_42576;

TEST(hash_42576, case1) {
	vector<string> participant = {"leo", "kiki", "eden"};
	vector<string> completion{"eden", "kiki"};
	string expected = "leo";

	EXPECT_EQ(expected, solution(participant, completion));
}

TEST(hash_42576, case2) {
	vector<string> participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
	vector<string> completion{"josipa", "filipa", "marina", "nikola"};
	string expected = "vinko";

	EXPECT_EQ(expected, solution(participant, completion));
}

TEST(hash_42576, case3) {
	vector<string> participant = {"mislav", "stanko", "mislav", "ana"};
	vector<string> completion{"stanko", "ana", "mislav"};
	string expected = "mislav";

	EXPECT_EQ(expected, solution(participant, completion));
}

TEST(hash_42576, case4) {
	vector<string> participant = {"mislav", "mislav", "mislav", "mislav"};
	vector<string> completion{"mislav", "mislav", "mislav"};
	string expected = "mislav";

	EXPECT_EQ(expected, solution(participant, completion));
}

TEST(hash_42576, case5) {
	vector<string> participant = {"mislav", "mislav", "mislav", "mislav", "ana"};
	vector<string> completion{"mislav", "mislav", "mislav", "mislav"};
	string expected = "ana";

	EXPECT_EQ(expected, solution(participant, completion));
}
