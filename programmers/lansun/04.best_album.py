# /usr/bin/python
# -*- coding: utf-8 -*-
# python 3.3

"""
속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

1. dict에 장르, 재생수, index 를 넣고, 재생수 기준으로 descending 하여 정렬
2. 정렬된 곡들의 장르만큼 반복문 돌아 장르별로 재생수 기준으로 다시 descending 하여 정렬
3. 두개씩 모아 베스트 앨범을 만든다고 했으니 count 가 2 미만만큼 루프돌아 배열에 해당 요소들을 pop 하여 리턴
"""
from collections import defaultdict, OrderedDict
import operator


def solution(genres, plays):
    answer = []
    songs = defaultdict(dict)
    n = len(genres)
    for genre, play, i in zip(genres, plays, list(range(n))):
        songs[genre][i] = play

    songs = OrderedDict(sorted(songs.items(), key=lambda x: sum(x[1].values()), reverse=True))

    for genre in songs.keys():
        genre_sorted = sorted(songs[genre].items(), key=operator.itemgetter(1), reverse=True)
        count = 0
        while genre_sorted and count < 2:
            answer.append(genre_sorted.pop(0)[0])
            count += 1

    return answer


def test(genres, plays):
    print '{}'.format(solution(genres, plays))


def main():
    genres = ['classic', 'pop', 'classic', 'classic', 'pop']
    plays = [500, 600, 150, 800, 2500]

    test(genres, plays)

main()