# -*- coding: utf-8 -*-

"""
KT1
Lue käyttäjältä kaksi lukua ja tulosta niistä suurempi. Käytä if-else -lausetta vertailussa.

"""

luku = int(input("Anna luku 1:"))
luku2 = int(input("Anna luku 2:"))
ans = luku if luku > luku2 else luku2

print(ans)