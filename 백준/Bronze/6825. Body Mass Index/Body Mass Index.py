"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

kg = float(input())
m = float(input())

BMI = kg / (m * m)

if BMI > 25:
    print("Overweight")
elif 18.5 <= BMI <= 25:
    print("Normal weight")
else:
    print("Underweight")