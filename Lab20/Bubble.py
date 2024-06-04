import random
import time

myData = []
for i in range(0,100000,1):
	myData.append(random.random())
#print(myData)

#Do the Bubble
startTime=time.time()
for i in range(9999,0,1):
	for j in range(1,i+1,1):
		if myData[j-1]>myData[j]:
			tmp = myData[j-1]
			myData[j-1]=myData[j]
			myDta[j]=tmp
endTime = time.time()
print(endTime-startTime)
