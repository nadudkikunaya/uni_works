# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

inp = input("Enter username : ")
correct = "Natthawat"
run = True

while run:
    if inp != correct:
        inp = input("Incorrect. Enter again : ")
    else:
        print("Hello,",inp)
        run = False
