# /usr/bin/python
# -*- coding: utf-8 -*-
# python 2.7


def robot_grid_path(x, y):
    if x == 1 or y == 1: return 1

    return robot_grid_path(x - 1, y) + robot_grid_path(x, y - 1)

x = 3
y = 3
print '(0, 0) to ({}, {}) : {}'.format(x, y, robot_grid_path(x, y))
