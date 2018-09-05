#!/usr/bin/env python
# -*- coding: utf-8 -*-
LEFT = 0
RIGHT = 2
BOTTOM = 1
TOP = 3


def checkTwoRecApart(rec1, rec2):
    if rec1[LEFT] > rec2[RIGHT] or rec1[RIGHT] < rec2[LEFT] or rec1[BOTTOM] > rec2[TOP] or rec1[TOP] < rec2[BOTTOM]:
        return True
    return False


def checkTwoRecMeetOnPoint(rec1, rec2):
    if (rec1[LEFT] == rec2[RIGHT] or rec1[RIGHT] == rec2[LEFT]) and (
            rec1[BOTTOM] == rec2[TOP] or rec1[TOP] == rec2[BOTTOM]):
        return True
    return False


def checkTwoRecMeetOnLine(rec1, rec2):
    if (rec1[LEFT] == rec2[RIGHT] or rec1[RIGHT] == rec2[LEFT]) and (
            rec2[BOTTOM] <= rec1[BOTTOM] < rec2[TOP] or rec2[BOTTOM] < rec1[TOP] <= rec2[TOP] or rec1[BOTTOM] <= rec2[
        BOTTOM] < rec1[TOP]):
        return True
    elif (rec1[BOTTOM] == rec2[TOP] or rec1[TOP] == rec2[BOTTOM]) and (
            rec2[LEFT] <= rec1[LEFT] < rec2[RIGHT] or rec2[LEFT] < rec1[RIGHT] <= rec2[RIGHT] or rec1[LEFT] < rec2[
        RIGHT] <= rec1[RIGHT]):
        return True
    return False


for case in range(4):
    inputList = list(map(int, input().split()))
    rec1 = inputList[0:4]
    rec2 = inputList[4:8]
    if checkTwoRecApart(rec1, rec2):
        print("d")
    elif checkTwoRecMeetOnPoint(rec1, rec2):
        print("c")
    elif checkTwoRecMeetOnLine(rec1, rec2):
        print("b")
    else:
        print("a")
