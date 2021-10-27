import re
import matplotlib.pyplot as plt

arrX = []
arrY1 = []
arrY2 = []

f = open('../gpi_Generic/data.csv')
line = f.readline()
while line:
    arr = re.split('[,\n]', line)
    arrX.append(int(arr[0]))
    arrY1.append(float(arr[1]))
    arrY2.append(float(arr[2]))
    line = f.readline()
f.close()

plt.plot(arrX, arrY1, 'D-r', label="time TBubbleSort")
plt.plot(arrX, arrY2, 'd-b', label="time DoubleBubbleSort")
plt.title("O(n)")
plt.legend()
plt.show()
