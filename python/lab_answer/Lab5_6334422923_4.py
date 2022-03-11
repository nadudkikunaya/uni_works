# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 08:25:56 2020

@author: usci
"""

n = int(input("Number of students : "))
i = 0
scMax = 0
scPass = 0
scFail = 0
total = 0

cPass = 0
cFail = 0

while i<n:
    inp = float(input("Student "+str(i+1)+" : "))
    i += 1
    total = total + inp
    if inp > scMax:
        scMax = inp
    
    if inp >= 5:
        scPass = scPass + inp
        cPass += 1
    else:
        scFail = scFail + inp
        cFail += 1


    
avgTotal = total/n

print("Average score :",avgTotal)

if cPass == 0:
    print("Average passing score : None")
else:
    avgPass = scPass/cPass
    print("Average passing score :",avgPass)
    
if cFail == 0:
    print("Average failing score : None")
else:
    avgFail = scFail/cFail
    print("Average failing score :",avgFail)
print("Highest score :",scMax)