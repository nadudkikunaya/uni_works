# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 08:41:34 2020

@author: usci
"""

balance = 50000


while balance > 0:
    wd = int(input("withdraw : "))
    if balance - wd < 0:
        print("Insufficient fund.")
    else:
        balance = balance - wd
    
print("Balance is 0.")
    
