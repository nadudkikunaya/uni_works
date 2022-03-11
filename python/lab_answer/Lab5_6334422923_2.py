# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 08:14:36 2020

@author: usci
"""


inp = input("Enter username : ")
correct = "Natthawat"
run = True
x = 0
while run:
    if inp != correct:
        x += 1
        if x == 3:
            print("Not allowed. Incorrect name.")
            break
        inp = input("Incorrect. Enter again : ")
    else:
        print("Hello,",inp)
        run = False
    
