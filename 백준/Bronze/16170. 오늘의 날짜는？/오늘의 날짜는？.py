"""
"""
import sys
from datetime import datetime

input = lambda: sys.stdin.readline().strip()

print(datetime.now().year)
print(datetime.now().month)
print(datetime.now().day)